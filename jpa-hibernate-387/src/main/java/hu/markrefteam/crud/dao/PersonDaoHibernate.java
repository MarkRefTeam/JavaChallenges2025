package hu.markrefteam.crud.dao;

import hu.markrefteam.crud.config.HibernateUtil;
import hu.markrefteam.crud.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PersonDaoHibernate implements PersonDao {

    @Override
    public Person save(Person person) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.persist(person); // or session.save(person)
            tx.commit();

            return person;
        } catch (Exception e) {
            if (tx != null) {
                try { tx.rollback(); } catch (Exception ignored) {}
            }
            throw new RuntimeException("Save failed", e);
        } finally {
            if (session != null) {
                try { session.close(); } catch (Exception ignored) {}
            }
        }
    }

    @Override
    public List<Person> searchByName(String query) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String q = "%" + query.toLowerCase() + "%";

            return session.createQuery("""
                            from Person p
                            where p.deleted = false
                              and (
                                   lower(p.firstName) like :q
                                   or lower(p.lastName) like :q
                              )
                            order by p.id
                            """, Person.class)
                    .setParameter("q", q)
                    .getResultList();

        } catch (Exception e) {
            throw new RuntimeException("Search failed", e);
        }
    }

    @Override
    public Optional<Person> findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("""
                            from Person p
                            where p.id = :id
                              and p.deleted = false
                            """, Person.class)
                    .setParameter("id", id)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new RuntimeException("FindById failed", e);
        }
    }

    @Override
    public List<Person> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Person p\n" +
                    "where p.deleted = false\n" +
                    "order by p.id", Person.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("FindAll failed", e);
        }
    }

    @Override
    public Person update(Person person) {
        if (person.getId() == null) {
            throw new IllegalArgumentException("Update failed: person.id is null");
        }

        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Person merged = (Person) session.merge(person);
            tx.commit();
            return merged;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Update failed", e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Person existing = session.get(Person.class, id);
            if (existing == null) {
                //tx.rollback();
                return false;
            }

            existing.setDeleted(true);
            existing.setDeletedAt(LocalDateTime.now());

            //session.remove(existing);
            session.merge(existing);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Delete failed", e);
        }
    }

    @Override
    public boolean restoreById(int id) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Person existing = session.get(Person.class, id);

            if (existing == null || !existing.isDeleted()) {
                tx.rollback();
                return false;
            }

            existing.setDeleted(false);
            existing.setDeletedAt(null);

            session.merge(existing);
            tx.commit();

            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Restore failed", e);
        }
    }

    @Override
    public List<Person> findDeleted() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("""
            from Person p
            where p.deleted = true
            order by p.id
        """, Person.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("FindDeleted failed", e);
        }
    }


}
