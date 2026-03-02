package hu.markrefteam.crud.dao;

import hu.markrefteam.crud.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    Person save(Person person);                // CREATE
    Optional<Person> findById(int id);         // READ (one)
    List<Person> findAll();                    // READ (all)
    List<Person> searchByName(String query);   // REC
    Person update(Person person);              // UPDATE
    boolean deleteById(int id);                // DELETE
    List<Person> findDeleted();                // RECYCLE BIN
    boolean restoreById(int id);               // RESTORE
}