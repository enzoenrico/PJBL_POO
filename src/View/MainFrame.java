package View;

import Controller.UserController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    public MainFrame() {
        super("Ez Rent");
        cardLayout = new CardLayout();
        Form form = new Form();
        UserDetails userDetails = new UserDetails();
        setLayout(cardLayout);

        new UserController(form, userDetails);

        add(form, "form");
        add(userDetails, "user details");
        form.viewUsers(e -> cardLayout.show(MainFrame.this.getContentPane(), "EZ Rent Users"));
        userDetails.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "form"));

        int FRAME_WIDTH = 700;
        int FRAME_HEIGHT = 700;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
