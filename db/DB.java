import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ez_rent";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
                connection.close(); // Fechando a conexão após uso
            } else {
                System.out.println("Falha ao estabelecer a conexão.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
            e.printStackTrace();
            return null;
        }
    }

    public static boolean runQuery(String query) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                connection.createStatement().execute(query);
                connection.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // public static String getUsers(String secret) {
    //     if (secret.equals("passwd")) {
    //         try{
    //             String data = getConnection().createStatement().executeQuery("SELECT * FROM usuario").toString();
    //             return data;
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     } else {
    //         System.out.println("Acesso negado.");
    //         return "Houve outro erro.";
    //     }
    //     return "Houve um erro.";
    // }

    public static boolean addUser(String firstName, String email, String password, String phone) {
        String query = "INSERT INTO usuario (id_usuario, nome_usuario, email_usuario, telefone_usuario, senha_usuario) VALUES (0, '"
                + firstName + "', '" + email + "', '" + phone + "', '" + password + "')";
        return runQuery(query);
    }
}
