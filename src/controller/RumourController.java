package src.controller;

import src.model.*;
import src.view.*;

import java.util.*;

/**
 * Controller หลักของระบบข่าวลือ
 * ควบคุม flow ระหว่าง Model และ View
 */
public class RumourController {

    private List<Rumour> rumours;
    private List<Report> reports;
    private List<User> users;
    private User currentUser;

    /**
     * โหลดข้อมูลจาก CSV ทั้งหมดตอนเริ่มระบบ
     */
    public RumourController() {
        rumours = CSVRepository.loadRumours();
        reports = CSVRepository.loadReports();
        users   = CSVRepository.loadUsers();
    }

    /**
     * ตรวจสอบ userId จากฐานข้อมูล
     * @return User ถ้าพบ, null ถ้าไม่พบ
     */
    public User login(String userId) {
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                currentUser = u;
                return u;
            }
        }
        return null;
    }

    /**
     * เปิดหน้ารวมข่าวลือ (หน้าหลัก)
     */
    public void openRumourListView() {
        new RumourListView(this, currentUser);
    }

    /**
     * เปิดหน้ารายละเอียดข่าวลือที่เลือก
     */
    public void openRumourDetail(String rumourId) {
        for (Rumour r : rumours) {
            if (r.getRumourId().equals(rumourId)) {
                int count = countReports(rumourId);
                new RumourDetailView(r, count, currentUser, this);
            }
        }
    }

    /**
     * เปิดหน้าสรุปผลข่าวลือ
     */
    public void openSummaryView() {
        new SummaryView(rumours);
    }

    /**
     * ให้ผู้ใช้รายงานข่าวลือ
     * (กันรายงานซ้ำ + กันข่าวที่ verify แล้ว)
     */
    public void reportRumour(Rumour rumour) {
        if (rumour.isVerified()) return;

        for (Report r : reports) {
            if (r.getUserId().equals(currentUser.getUserId())
                    && r.getRumourId().equals(rumour.getRumourId())) {
                return;
            }
        }

        reports.add(new Report(
                "R" + (reports.size() + 1),
                currentUser.getUserId(),
                rumour.getRumourId(),
                "2026-02-07",
                "false_information"
        ));

        rumour.updateStatusByReport(countReports(rumour.getRumourId()));
    }

    /**
     * ให้ผู้ตรวจสอบยืนยันข่าว (TRUE / FALSE)
     */
    public void verifyRumour(Rumour rumour, String result) {
        rumour.verify(result);
    }

    /**
     * นับจำนวนรายงานของข่าวหนึ่งข่าว
     */
    private int countReports(String rumourId) {
        int count = 0;
        for (Report r : reports) {
            if (r.getRumourId().equals(rumourId)) count++;
        }
        return count;
    }

    /**
     * ส่ง list ข่าวทั้งหมดให้ View
     */
    public List<Rumour> getRumours() {
        return rumours;
    }
}





