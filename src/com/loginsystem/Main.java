package com.loginsystem;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        boolean success = dao.login("testuser@example.com", "test123");

        if (success) {
            System.out.println("🎉 Welcome!");
        } else {
            System.out.println("❌ Invalid credentials.");
        }
    }
}
