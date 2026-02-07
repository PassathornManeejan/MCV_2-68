package src.view;

import src.controller.RumourController;
import src.model.User;

import javax.swing.*;
import java.awt.*;

/**
 * หน้า Login ของระบบ
 */
public class LoginView extends JFrame {

    public LoginView(RumourController controller) {

        setTitle("Login");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JLabel label = new JLabel("Enter User ID", SwingConstants.CENTER);
        JTextField field = new JTextField();
        JButton loginBtn = new JButton("Login");

        add(label, BorderLayout.NORTH);
        add(field, BorderLayout.CENTER);
        add(loginBtn, BorderLayout.SOUTH);

        loginBtn.addActionListener(e -> {
            User user = controller.login(field.getText().trim());
            if (user == null) {
                JOptionPane.showMessageDialog(this, "User not found");
            } else {
                dispose();
                controller.openRumourListView();
            }
        });

        setVisible(true);
    }
}
