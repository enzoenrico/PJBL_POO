package Model;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class User {
    private int id;
    private String name;
    private String email;
    private String telephone;
    private String passwd = null;

    public User(String name, String email, String telephone) {
        this.id = 11;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    // Method to get all users
    public static User[] getAll() throws SQLException {
        Connection conn = DB.getConnection();
        if (conn != null) {
            try {

                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery("SELECT * FROM usuario");
                List<User> userList = new ArrayList<>();
                while (result.next()) {
                    User user = new User(
                            result.getString("nome_usuario"),
                            result.getString("email_usuario"),
                            result.getString("telefone_usuario"));
                    userList.add(user);
                }
                return userList.toArray(new User[0]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static User getUser(String userEmail) throws SQLException {
        Connection conn = DB.getConnection();
        if (conn != null) {
            String query = "SELECT * FROM usuario WHERE email_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, userEmail);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                User user = new User(
                        result.getString("nome_usuario"),
                        result.getString("email_usuario"),
                        result.getString("telefone_usuario"));
                return user;
            }
        }
        return null;
    }

    // Method to add a new user
    public static boolean setUser(User user) throws SQLException {
        Connection conn = DB.getConnection();
        if (conn != null) {
            String query = "INSERT INTO usuario (id_usuario, nome_usuario, email_usuario, telefone_usuario, senha_usuario) VALUES ()";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getTelephone());
            stmt.setString(5, user.getPasswd());
            return stmt.executeUpdate() > 0;
        }
        return false;
    }

    // Method to delete a user by ID
    public static boolean deleteUser(int id) throws SQLException {
        Connection conn = DB.getConnection();
        if (conn != null) {
            String query = "DELETE FROM usuario WHERE id_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
        return false;
    }

    // Method to update a user
    public static boolean updateUser(User user, int searchId) throws SQLException {
        Connection conn = DB.getConnection();
        if (conn != null) {
            String query = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, telefone_usuario = ? WHERE id_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getTelephone());
            stmt.setInt(4, searchId);
            return stmt.executeUpdate() > 0;
        }
        return false;
    }
}
