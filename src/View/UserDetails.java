package View;

import Model.User;
import java.awt.*;
import java.awt.event.ActionListener;
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
        DefaultTableModel defaultTableModel = (DefaultTableModel) userTable.getModel();
        defaultTableModel.setColumnIdentifiers(userTableColumn);
        int i = 0;
        while (i < objects.size()) {
            try {
                User[] tmp = new User[] { User.getUser(objects.get(i).getEmail()) };
                defaultTableModel.addRow(tmp);
            } catch (SQLException e) {
                // Handle the SQLException here
                e.printStackTrace();
            }
            i++;
        }
    }

    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
