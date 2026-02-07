package src.model;

import java.io.*;
import java.util.*;

/**
 * Repository สำหรับอ่านข้อมูลจากไฟล์ CSV
 */
public class CSVRepository {

    /**
     * โหลดข้อมูลข่าวลือทั้งหมด
     */
    public static List<Rumour> loadRumours() {
        List<Rumour> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/rumours.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length < 7) continue;
                list.add(new Rumour(
                        d[0], d[1], d[2], d[3],
                        Integer.parseInt(d[4]), d[5], d[6]
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * โหลดข้อมูลการรายงานข่าว
     */
    public static List<Report> loadReports() {
        List<Report> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/reports.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length < 5) continue;
                list.add(new Report(d[0], d[1], d[2], d[3], d[4]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * โหลดข้อมูลผู้ใช้งาน
     */
    public static List<User> loadUsers() {
        List<User> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/users.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length < 3) continue;
                list.add(new User(d[0], d[1], d[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}





