package hu.markrefteam.people.dao;

import hu.markrefteam.people.connection.ConnectionFactory;
import hu.markrefteam.people.model.Gender;
import hu.markrefteam.people.model.HighestEducation;
import hu.markrefteam.people.model.Person;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDao {

    public Person insert(Person person) {
        String sql = """
                INSERT INTO person (
                    first_name, last_name, mother_name, father_name,
                    birth_date, gender, highest_education, number_of_children
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getMotherName());
            ps.setString(4, person.getFatherName());
            if (person.getBirthDate() != null) {
                ps.setDate(5,
                        Date.valueOf(person.getBirthDate()));
            } else {
                ps.setNull(5, Types.DATE);
            }
            //ps.setDate(5, Date.valueOf(person.getBirthDate()));
            ps.setString(6, person.getGender().name());
            ps.setString(7, person.getHighestEducation().name());
            ps.setInt(8, person.getNumberOfChildren());

            //ps.executeUpdate();

            int affected = ps.executeUpdate();
            if (affected != 1) {
                throw new IllegalStateException("Insert failed, affected rows: " + affected);
            }


            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    person.setId(rs.getInt(1));
                    return person;
                }
                throw new IllegalStateException("No ID generated");
            }

        } catch (SQLException e) {
            throw new IllegalStateException("DB error in insert()", e);
        }
    }

    public Person update(Person person) {
        if (person.getId() == null) {
            throw new IllegalArgumentException("Cannot update person without id");
        }

        String sql = """
        UPDATE person
        SET first_name = ?,
            last_name = ?,
            mother_name = ?,
            father_name = ?,
            birth_date = ?,
            gender = ?,
            highest_education = ?,
            number_of_children = ?
        WHERE id = ?
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getMotherName());
            ps.setString(4, person.getFatherName());

            if (person.getBirthDate() != null) {
                ps.setDate(5, Date.valueOf(person.getBirthDate()));
            } else {
                ps.setNull(5, Types.DATE);
            }

            ps.setString(6, person.getGender().name());
            ps.setString(7, person.getHighestEducation().name());
            ps.setInt(8, person.getNumberOfChildren());

            ps.setInt(9, person.getId());

            int affected = ps.executeUpdate();
            if (affected != 1) {
                throw new IllegalStateException("Update failed, affected rows: " + affected);
            }

        } catch (SQLException e) {
            throw new IllegalStateException("DB error in update(id=" + person.getId() + ")", e);
        }
        return person;
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM person WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int affected = ps.executeUpdate();
            if (affected == 0) {
                return false;
            }
            if (affected != 1) {
                throw new IllegalStateException("Delete affected rows: " + affected);
            }
            return true;

        } catch (SQLException e) {
            throw new IllegalStateException("DB error in deleteById(" + id + ")", e);
        }
    }


    public List<Person> findAll() {
        String sql = """
                SELECT id, first_name, last_name, mother_name, father_name,
                       birth_date, gender, highest_education, number_of_children
                FROM person
                ORDER BY id
                """;

        List<Person> result = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                result.add(mapRow(rs));
            }

            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("DB error in findAll()", e);
        }
    }

    public Optional<Person> findById(int id) {
        String sql = """
                SELECT id, first_name, last_name, mother_name, father_name,
                       birth_date, gender, highest_education, number_of_children
                FROM person
                WHERE id = ?
                """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new IllegalStateException("DB error in findById(" + id + ")", e);
        }
    }

    private Person mapRow(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");

        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String motherName = rs.getString("mother_name");
        String fatherName = rs.getString("father_name");

        Date birthDateSql = rs.getDate("birth_date");
        LocalDate birthDate = (birthDateSql != null) ? birthDateSql.toLocalDate() : null;

        Gender gender = Gender.valueOf(rs.getString("gender"));
        HighestEducation education = HighestEducation.valueOf(rs.getString("highest_education"));

        int numberOfChildren = rs.getInt("number_of_children");

        return Person.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .motherName(motherName)
                .fatherName(fatherName)
                .birthDate(birthDate)
                .gender(gender)
                .highestEducation(education)
                .numberOfChildren(numberOfChildren)
                .build();
    }
}
