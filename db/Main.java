import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Creating users Bob and Alice
            User Kwon = new User(3, "Kwon", "japinha@example.com", "123456789");
            Kwon.setPasswd("password123");

            User pedro = new User(4, "Pedro", "pedroca@example.com", "987654321");
            pedro.setPasswd("password456");

            // Adding users to the database
            if (UserMethods.setUser(Kwon)) {
                System.out.println("User kwon inserted successfully.");
            } else {
                System.out.println("Failed to insert user kwon.");
            }

            if (UserMethods.setUser(pedro)) {
                System.out.println("User pedro inserted successfully.");
            } else {
                System.out.println("Failed to insert user pedro.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
