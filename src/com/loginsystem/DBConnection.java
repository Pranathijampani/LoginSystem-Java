package com.loginsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/login_system";
	private static final String USER = "root";
	private static final String PASSWORD = "admin123"; // very important

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8+ driver
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(" Failed to connect to database: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
