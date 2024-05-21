import javax.swing.*;
import java.awt.FlowLayout; // Add this import statement

public class inter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Input Interface");

        JTextField username = new JTextField(20);
        JTextField useremail = new JTextField(20);
        // JTextField userpass = new JTextField(30, );
        JPasswordField userpass = new JPasswordField(15);
        JTextField userPhone = new JTextField(15);

        JButton button = new JButton("Submit");

        button.addActionListener(e ->{
            String firstName = username.getText();
            String email = useremail.getText();
            String password = userpass.getPassword().toString();
            String phone = userPhone.getText();
            if(firstName.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
                button.setText("Please fill all fields");
                return;
            }
            // String query = "INSERT INTO usuario (id_usuario, nome_usuario, email_usuario, telefone_usuario, senha_usuario) VALUES (0, '" + firstName + "', '" + email + "', '" + phone + "', '" + password + "')";
            // DB.runQuery(query); // Access the runQuery method in a static way
            DB.addUser(firstName, email, password, phone);
            // System.out.println(DB.getUsers("passwd"));
            button.setText("Submitted");
            return;
        } );


        //creating users table
        JTable table = new JTable();

        // Add the components to the frame
        frame.getContentPane().add(new JLabel("Name:"));
        frame.getContentPane().add(username);
        frame.getContentPane().add(new JLabel("Email:"));
        frame.getContentPane().add(useremail);
        frame.getContentPane().add(new JLabel("Password:"));
        frame.getContentPane().add(userpass);
        frame.getContentPane().add(new JLabel("Phone:"));
        frame.getContentPane().add(userPhone);
        frame.getContentPane().add(button);

        frame.getContentPane().add(table);

        // Set the layout manager
        frame.setLayout(new FlowLayout());

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(500, 200);

        // Set the frame to be always on top
        frame.setAlwaysOnTop(true);

        // Make the frame visible
        frame.setVisible(true);
    }
}
