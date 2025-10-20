package com.markref.security.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H2Base {

    public static void main(String[] args) {

        try {
            Class.forName("org.h2.Driver");

            String jdbcURL = "jdbc:h2:./data/db";

            try (Connection connection = DriverManager.getConnection(jdbcURL);
                 Statement statement = connection.createStatement()) {

                statement.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255))");
                statement.execute("MERGE INTO users KEY(id) VALUES (1, 'Márk')");
                statement.execute("MERGE INTO users KEY(id) VALUES (2, 'GP')");
                statement.execute("MERGE INTO users KEY(id) VALUES (3, 'Zino')");

                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    System.out.println("User: " + id + " - " + name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
