import java.sql.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Creating users Bob and Alice
            User enzo = new User(0, "enzo", "enzinho@example.com", "123456789");
            enzo.setPasswd("password123");

            User george = new User(0, "george", "georgeca@example.com", "987654321");
            george.setPasswd("password456");

            // Adding users to the database
            if (UserMethods.setUser(enzo)) {
                System.out.println("User enzo inserted successfully.");
            } else {
                System.out.println("Failed to insert user enzo.");
            }

            if (UserMethods.setUser(george)) {
                System.out.println("User george inserted successfully.");
            } else {
                System.out.println("Failed to insert user george.");
            }

            // Create and show the Swing interface
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Cadastro do Usuário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
