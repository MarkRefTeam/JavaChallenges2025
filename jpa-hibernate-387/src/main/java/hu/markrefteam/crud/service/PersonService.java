package hu.markrefteam.crud.service;

import hu.markrefteam.crud.dao.PersonDao;
import hu.markrefteam.crud.entity.Person;

import java.util.List;
import java.util.Optional;

public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person create(Person p) {
        validate(p);
        return personDao.save(p);
    }

    public List<Person> search(String query) {
        if (query == null || query.isBlank()) {
            throw new IllegalArgumentException("Search query cannot be empty");
        }
        return personDao.searchByName(query);
    }

    public Optional<Person> getById(int id) {
        return personDao.findById(id);
    }

    public List<Person> getAll() {
        return personDao.findAll();
    }

    public Person update(Person p) {
        validate(p);
        if (true) throw new RuntimeException("Simulated crash");
        return personDao.update(p);
    }

    public boolean delete(int id) {
        return personDao.deleteById(id);
    }

    public boolean restoreById(int id) {
        return personDao.restoreById(id);
    }

    public List<Person> getDeleted() {
        return personDao.findDeleted();
    }

    public boolean restore(int id) {
        return personDao.restoreById(id);
    }

    private void validate(Person p) {

        p.setFirstName(trimToNull(p.getFirstName()));
        p.setLastName(trimToNull(p.getLastName()));
        p.setMotherName(trimToNull(p.getMotherName()));
        p.setFatherName(trimToNull(p.getFatherName()));

        requireNonBlank(p.getFirstName(), "First name");
        requireNonBlank(p.getLastName(), "Last name");

        maxLen(p.getFirstName(), 100, "First name");
        maxLen(p.getLastName(), 100, "Last name");
        maxLen(p.getMotherName(), 100, "Mother name");
        maxLen(p.getFatherName(), 100, "Father name");

        if (p.getBirthDate() != null && p.getBirthDate().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Birth date cannot be in the future");
        }

        if (p.getGender() == null) throw new IllegalArgumentException("Gender is required");
        if (p.getHighestEducation() == null) throw new IllegalArgumentException("Highest education is required");

        if (p.getNumberOfChildren() < 0) {
            throw new IllegalArgumentException("Number of children must be >= 0");
        }
    }

    private String trimToNull(String s) {
        if (s == null) return null;
        String t = s.trim();
        return t.isEmpty() ? null : t;
    }

    private void requireNonBlank(String s, String field) {
        if (s == null || s.isBlank()) throw new IllegalArgumentException(field + " is required");
    }

    private void maxLen(String s, int max, String field) {
        if (s != null && s.length() > max) throw new IllegalArgumentException(field + " max length is " + max);
    }

    private void checkRequired(String s, String field) {
        if (s == null || s.isBlank())
            throw new IllegalArgumentException(field + " is required");
    }

    private void checkLength(String s, int max, String field) {
        if (s != null && s.length() > max)
            throw new IllegalArgumentException(field + " too long");
    }
}