package com.loginsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    
    public boolean registerUser(User user) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String email, String password) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            System.out.println("❌ DB connection failed.");
            return false;
        }

        try {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("✅ Login successful!");
                return true;
            } else {
                System.out.println("❌ Login failed: email or password incorrect.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
