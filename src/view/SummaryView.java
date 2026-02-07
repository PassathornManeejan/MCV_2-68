package src.view;

import src.model.Rumour;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * หน้าสรุปผลข่าวลือ
 */
public class SummaryView extends JFrame {

    public SummaryView(List<Rumour> rumours) {

        setTitle("Summary");
        setSize(700, 300);
        setLocationRelativeTo(null);

        String[] columns = {"Rumour ID", "Title", "Status", "Verified"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Rumour r : rumours) {
            if (r.getStatus().equals("panic")
                    || !r.getVerifiedStatus().equals("UNVERIFIED")) {
                model.addRow(new Object[]{
                        r.getRumourId(),
                        r.getTitle(),
                        r.getStatus(),
                        r.getVerifiedStatus()
                });
            }
        }

        JTable table = new JTable(model);
        add(new JScrollPane(table));

        setVisible(true);
    }
}



