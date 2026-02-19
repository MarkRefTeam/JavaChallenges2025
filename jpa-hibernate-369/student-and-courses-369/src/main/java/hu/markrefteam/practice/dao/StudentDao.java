package hu.markrefteam.practice.dao;

import hu.markrefteam.practice.entity.Student;
import jakarta.persistence.EntityManager;

public class StudentDao {

    private EntityManager em;

    public StudentDao(EntityManager em) {
        this.em = em;
    }

    public void save(Student student) {
        em.persist(student);
    }

    public Student findById(Long id) {
        return em.find(Student.class,id);
    }

    public boolean existsByEmail(String email) {
        Long count = em.createQuery(
                        "select count(s) from Student s where s.email = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
        return count > 0;
    }

    public Student updateEmail(Long studentId, String newEmail) {
        Student student = em.find(Student.class, studentId);
        if (student == null) return null;

        student.setEmail(newEmail);
        return student;
    }


}
