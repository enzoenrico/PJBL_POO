import java.sql.*;

public class UserMethods {

    // Method to get all users
    public static ResultSet getAll() throws SQLException {
        Connection conn = DB.getConnection();
        if (conn != null) {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery("SELECT * FROM usuario");
        }
        return null;
    }

    // Method to get a user by email and password
    public static User getUser(String pass, String userEmail) throws SQLException {
        Connection conn = DB.getConnection();
        if (conn != null) {
            String query = "SELECT * FROM usuario WHERE email_usuario = ? AND senha_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, userEmail);
            stmt.setString(2, pass);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                User user = new User(
                        result.getInt("id_usuario"),
                        result.getString("nome_usuario"),
                        result.getString("email_usuario"),
                        result.getString("telefone_usuario")
                );
                return user;
            }
        }
        return null;
    }

    // Method to add a new user
    public static boolean setUser(User user) throws SQLException {
        Connection conn = DB.getConnection();
        if (conn != null) {
            String query = "INSERT INTO usuario (id_usuario, nome_usuario, email_usuario, telefone_usuario, senha_usuario) VALUES (?, ?, ?, ?, ?)";
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
