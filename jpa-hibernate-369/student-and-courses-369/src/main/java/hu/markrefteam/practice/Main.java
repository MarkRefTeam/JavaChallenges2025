package hu.markrefteam.practice;

import hu.markrefteam.practice.bootstrap.DataInitializer;
import hu.markrefteam.practice.dao.CourseDao;
import hu.markrefteam.practice.dao.StudentDao;
import hu.markrefteam.practice.entity.Course;
import hu.markrefteam.practice.service.CourseService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("studentCoursePU");
        EntityManager em = emf.createEntityManager();

        CourseDao courseDao = new CourseDao(em);
        StudentDao studentDao = new StudentDao(em);

        CourseService courseService = new CourseService(courseDao, studentDao);

        em.getTransaction().begin();

        Course java = courseService.createCourse("Java", "Hibernate basics", 5);
        Course python = courseService.createCourse("Python", "Security scripting", 4);

        courseService.addStudentToCourse(java.getId(), "Márk", "Sz", "mark@test.hu");
        courseService.addStudentToCourse(java.getId(), "Ancsa", "Sz", "ancsa@test.hu");
        courseService.addStudentToCourse(python.getId(), "Jazi", "Mini", "jazi@test.hu");

        em.getTransaction().commit();

        //courseService.seedDemoData();

        System.out.println("\n--- N+1 DEMO ---");
        em.getTransaction().begin();

        var coursesNPlus1 = courseDao.findAll();
        for (var c : coursesNPlus1) {
            System.out.println(c.getName() + " -> students: " + c.getStudents().size());
        }

        em.getTransaction().commit();

        System.out.println("\n--- JOIN FETCH FIX ---");
        em.getTransaction().begin();

        var coursesJoinFetch = courseDao.findAllWithStudentsJoinFetch();
        for (var c : coursesJoinFetch) {
            System.out.println(c.getName() + " -> students: " + c.getStudents().size());
        }

        em.getTransaction().commit();

        System.out.println("\n--- CRUD DEMO ---");
        em.getTransaction().begin();

        var javaCourse = em.find(Course.class, java.getId());
        var studentToUpdate = javaCourse.getStudents()
                .stream()
                .findFirst()
                .orElseThrow();
        studentDao.updateEmail(studentToUpdate.getId(), "updated@mail.com");

        courseDao.deleteById(python.getId());
        System.out.println("Python course after delete: " + em.find(Course.class, python.getId()));

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
