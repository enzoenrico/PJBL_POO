package View;

import Model.DB;
import Model.User;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserDetails extends JPanel {
    private JTable userTable;

    private String[] userTableColumn = { "ID", "Name", "Email", "Phone" };

    private JButton backButton;

    public UserDetails() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JToolBar toolBar = new JToolBar();
        userTable = new JTable();
        JScrollPane userTableScroll = new JScrollPane(userTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(userTableScroll);

    }

    public void getUsers(ArrayList<User> objects) {
        try {
            PreparedStatement getUsersQuery = DB.getConnection().prepareStatement("SELECT * FROM usuario");
            ResultSet rs = getUsersQuery.executeQuery();

            // Column Names
            String[] columnNames = { "First Name", "Email", "Phone", "Password" };

            // Create a list to hold users
            ArrayList<User> users = new ArrayList<>();

            // Process the result set
            while (rs.next()) {
                String firstname = rs.getString("nome_usuario");
                String email = rs.getString("email_usuario");
                String phone = rs.getString("telefone_usuario");

                // Create a user and add it to the list
                users.add(new User(firstname, email, phone));
            }

            // Data
            Object[][] data = new Object[users.size()][4];
            for (int i = 0; i < users.size(); i++) {
                data[i][0] = users.get(i).getName();
                data[i][1] = users.get(i).getEmail();
                data[i][2] = users.get(i).getTelephone();
            }

            // Create Table Model
            DefaultTableModel model = new DefaultTableModel(data, columnNames);

            // Set Model to userTable
            userTable.setModel(model);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
