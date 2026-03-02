import hu.markrefteam.crud.config.HibernateUtil;
import hu.markrefteam.crud.dao.PersonDao;
import hu.markrefteam.crud.dao.PersonDaoHibernate;
import hu.markrefteam.crud.entity.Gender;
import hu.markrefteam.crud.entity.HighestEducation;
import hu.markrefteam.crud.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PersonDaoHibernateTest {

    private final PersonDao dao = new PersonDaoHibernate();

    private Person testPerson(String first, String last) {
        Person p = new Person();
        p.setFirstName("TEST_" + first);
        p.setLastName("TEST_" + last);
        p.setGender(Gender.MALE);
        p.setHighestEducation(HighestEducation.HIGH_SCHOOL);
        p.setNumberOfChildren(0);
        return p;
    }

    @AfterEach
    void cleanup() {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.createMutationQuery("delete from Person").executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @AfterEach
    void cleanupTestData() {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.createNativeQuery("DELETE FROM person WHERE first_name LIKE 'TEST_%'")
                    .executeUpdate();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Test cleanup failed", e);
        }
    }

    @Test
    void save_shouldPersistAndAssignId() {
        // Arrange
        Person p = new Person();
        p.setFirstName("TEST_Mark");
        p.setLastName("TEST_GTP");
        p.setGender(Gender.OTHER);
        p.setHighestEducation(HighestEducation.HIGH_SCHOOL);
        p.setNumberOfChildren(1);

        // Act
        Person saved = dao.save(p);

        // Assert (ID + default soft delete state)
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getId()).isGreaterThan(0);

        assertThat(saved.isDeleted()).isFalse();
        assertThat(saved.getDeletedAt()).isNull();

        // Assert (re-read from DB)
        Optional<Person> found = dao.findById(saved.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getFirstName()).isEqualTo("TEST_Mark");
        assertThat(found.get().getLastName()).isEqualTo("TEST_GTP");
    }

    @Test
    void findAll_shouldReturnOnlyNotDeleted() {
        Person p1 = testPerson("A", "One");
        Person p2 = testPerson("B", "Two");

        dao.save(p1);
        dao.save(p2);

        dao.deleteById(p1.getId());

        List<Person> result = dao.findAll();

        assertThat(result)
                .hasSize(1)
                .allMatch(p -> !p.isDeleted())
                .extracting(Person::getLastName)
                .containsExactly("TEST_Two");
    }

    @Test
    void deleteById_shouldSoftDelete() {
        Person p = dao.save(testPerson("Soft", "Delete"));

        boolean deleted = dao.deleteById(p.getId());

        assertThat(deleted).isTrue();

        Optional<Person> after = dao.findById(p.getId());

        assertThat(after).isEmpty();
    }

    @Test
    void restoreById_shouldUndoSoftDelete() {
        Person p = dao.save(testPerson("Restore", "Me"));

        dao.deleteById(p.getId());
        boolean restored = dao.restoreById(p.getId());

        assertThat(restored).isTrue();

        Optional<Person> result = dao.findById(p.getId());

        assertThat(result).isPresent();
        assertThat(result.get().isDeleted()).isFalse();
    }

    @Test
    void searchByName_shouldIgnoreDeleted() {
        Person active = dao.save(testPerson("Search", "Alive"));
        Person deleted = dao.save(testPerson("Search", "Dead"));

        dao.deleteById(deleted.getId());

        List<Person> result = dao.searchByName("Search");

        assertThat(result)
                .hasSize(1)
                .allMatch(p -> !p.isDeleted())
                .extracting(Person::getLastName)
                .containsExactly("TEST_Alive");
    }
}