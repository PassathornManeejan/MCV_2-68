package src.view;

import src.controller.RumourController;
import src.model.Rumour;
import src.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/**
 * หน้ารวมข่าวลือ (หน้าหลัก)
 */
public class RumourListView extends JFrame {

    public RumourListView(RumourController controller, User user) {

        setTitle("Rumour List");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] columns = {"Rumour ID", "Title", "Credibility", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Rumour r : controller.getRumours()) {
            model.addRow(new Object[]{
                    r.getRumourId(),
                    r.getTitle(),
                    r.getCredibilityScore(),
                    r.getStatus()
            });
        }

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton summaryBtn = new JButton("View Summary");
        add(summaryBtn, BorderLayout.SOUTH);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                controller.openRumourDetail(
                        model.getValueAt(row, 0).toString()
                );
            }
        });

        summaryBtn.addActionListener(e -> controller.openSummaryView());

        setVisible(true);
    }
}



