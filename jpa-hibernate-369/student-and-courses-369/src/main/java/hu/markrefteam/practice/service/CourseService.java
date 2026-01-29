package hu.markrefteam.practice.service;

import hu.markrefteam.practice.dao.CourseDao;
import hu.markrefteam.practice.dao.StudentDao;
import hu.markrefteam.practice.entity.Course;
import hu.markrefteam.practice.entity.Student;

import java.util.List;

public class CourseService {

    private final CourseDao courseDao;
    private final StudentDao studentDao;

    public CourseService(CourseDao courseDao, StudentDao studentDao) {
        this.courseDao = courseDao;
        this.studentDao = studentDao;
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

    public Course createCourse(String name, String description, int credits) {
        validateCourseInput(name, description, credits);

        Course course = new Course(name, description, credits);
        courseDao.save(course);
        return course;
    }

    public void addStudentToCourse(Long courseId, String firstName, String lastName, String email) {
        if (courseId == null) throw new IllegalArgumentException("courseId cannot be null");
        validateStudentInput(firstName, lastName, email);

        Course course = courseDao.findById(courseId);
        if (course == null) throw new IllegalArgumentException("Course not found: " + courseId);

        if (studentDao.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists: " + email);
        }

        Student student = new Student(firstName, lastName, email);
        course.addStudent(student);
        courseDao.save(course);
    }

    public List<Course> listCourses() {
        return courseDao.findAll();
    }

    private void validateCourseInput(String name, String description, int credits) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name cannot be empty");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("description cannot be empty");
        if (credits <= 0) throw new IllegalArgumentException("credits must be > 0");
    }

    private void validateStudentInput(String firstName, String lastName, String email) {
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("firstName cannot be empty");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("lastName cannot be empty");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("email cannot be empty");
    }
}
