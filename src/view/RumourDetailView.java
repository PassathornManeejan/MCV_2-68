package src.view;

import src.model.*;
import src.controller.RumourController;

import javax.swing.*;
import java.awt.*;

/**
 * หน้ารายละเอียดข่าวลือ
 */
public class RumourDetailView extends JFrame {

    public RumourDetailView(Rumour rumour, int reportCount,
                            User user, RumourController controller) {

        setTitle("Rumour Detail");
        setSize(420, 360);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0,1,5,5));

        panel.add(new JLabel("Title: " + rumour.getTitle()));
        panel.add(new JLabel("Source: " + rumour.getSource()));
        panel.add(new JLabel("Date: " + rumour.getCreatedDate()));
        panel.add(new JLabel("Credibility: " + rumour.getCredibilityScore()));
        panel.add(new JLabel("Reports: " + reportCount));
        panel.add(new JLabel("Status: " + rumour.getStatus()));
        panel.add(new JLabel("Verified: " + rumour.getVerifiedStatus()));

        JButton reportBtn = new JButton("Report Rumour");
        JButton trueBtn = new JButton("Verify TRUE");
        JButton falseBtn = new JButton("Verify FALSE");

        reportBtn.setEnabled(user.getRole().equals("user") && !rumour.isVerified());
        trueBtn.setEnabled(user.getRole().equals("checker"));
        falseBtn.setEnabled(user.getRole().equals("checker"));

        reportBtn.addActionListener(e -> {
            controller.reportRumour(rumour);
            dispose();
        });

        trueBtn.addActionListener(e -> {
            controller.verifyRumour(rumour, "TRUE");
            dispose();
        });

        falseBtn.addActionListener(e -> {
            controller.verifyRumour(rumour, "FALSE");
            dispose();
        });

        panel.add(reportBtn);
        panel.add(trueBtn);
        panel.add(falseBtn);

        add(panel);
        setVisible(true);
    }
}




