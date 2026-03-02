package hu.markrefteam.practice.dao;

import hu.markrefteam.practice.entity.Course;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CourseDao {

    private EntityManager em;

    public CourseDao(EntityManager em) {
        this.em = em;
    }

    public void save(Course course) {
        em.persist(course);
    }

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public List<Course> findAll() {
        return em
                .createQuery("SELECT c FROM Course c", Course.class)
                .getResultList();
    }

    public List<Course> findAllWithStudentsJoinFetch() {
        return em
                .createQuery("""
                        
                            SELECT DISTINCT c
                        FROM Course c
                        LEFT JOIN FETCH c.students
                        """, Course.class)
                .getResultList();
    }

    public void deleteById(Long id) {
        Course course = em.find(Course.class, id);
        if (course != null) {
            em.remove(course);
        }
    }
}