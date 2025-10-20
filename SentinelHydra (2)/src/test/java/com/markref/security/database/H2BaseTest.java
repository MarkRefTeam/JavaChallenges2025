package com.markref.security.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class H2BaseTest {

    private Connection connection;

    @BeforeEach
    void setup() throws Exception {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE users(id INT PRIMARY KEY, name VARCHAR(255))");
        }
    }

    @Test
    void testInsertAndQueryUsers() throws Exception {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("MERGE INTO users KEY(id) VALUES (1, 'Márk')");
            stmt.execute("MERGE INTO users KEY(id) VALUES (2, 'GP')");
            stmt.execute("MERGE INTO users KEY(id) VALUES (3, 'Zino')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY id");

            int count = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("User: " + id + " - " + name);

                if (id == 1) assertEquals("Márk", name);
                if (id == 2) assertEquals("GP", name);
                if (id == 3) assertEquals("Zino", name);
                count++;
            }
            assertEquals(3, count);
        }
    }

    @AfterEach
    void tearDown() throws Exception {
        connection.close();
    }
}
