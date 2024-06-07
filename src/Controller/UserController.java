package Controller;

import Model.DB;
import Model.User;
import View.Form;
import View.UserDetails;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserController {
    // database file
    private DB database;
    private Form form;
    private UserDetails userDetails;

    public UserController(Form form, UserDetails userDetails) {
        this.database = new DB();
        this.form = form;
        this.userDetails = userDetails;

        // submit user
        this.form.submitUsers(e -> {
            String firstname = this.form.getFirstname().trim();
            String email = this.form.getEmail().trim();
            String phone = this.form.getPhone().trim();
            String passwd = this.form.getPassword().trim();

            // simple validations
            if (firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            DB.addUser(firstname, email, phone, passwd);
            this.form.reset(true);
        });

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("teste", "asdasd", "asdasd"));
        // User[] users = new User[3];

        this.userDetails.getUsers(users);
    }
}
