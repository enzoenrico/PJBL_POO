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
            String lastname = this.form.getLastname().trim();

            // simple validations
            if (firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            DB.addUser("teste", "teste@teste.dev", "123456", "1234567890");
            this.form.reset(true);
        });

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("teste", "asdasd", "asdasd"));
        // User[] users = new User[3];

        this.userDetails.getUsers(users);
    }
}
