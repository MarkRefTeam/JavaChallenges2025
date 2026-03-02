package hu.markrefteam.practice.bootstrap;

import hu.markrefteam.practice.dao.CourseDao;
import hu.markrefteam.practice.entity.Course;
import hu.markrefteam.practice.entity.Student;

public class DataInitializer {

    private final CourseDao courseDao;

    public DataInitializer(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void seedDemoData() {

        Course javaCourse = new Course("Java", "Hibernate basics", 5);
        javaCourse.addStudent(new Student("Mark", "Sz", "mark@test.hu"));
        javaCourse.addStudent(new Student("Ancsa", "Sz", "ancsa@test.hu"));

        Course pythonCourse = new Course("Python", "Security scripting", 4);
        pythonCourse.addStudent(new Student("Jazi", "Mini", "jazi@test.hu"));

        courseDao.save(javaCourse);
        courseDao.save(pythonCourse);
    }
}
