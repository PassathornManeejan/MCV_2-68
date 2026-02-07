package src.model;

/**
 * Model ข่าวลือ
 * เก็บข้อมูลข่าวและสถานะต่าง ๆ
 */
public class Rumour {

    private String rumourId;
    private String title;
    private String source;
    private String createdDate;
    private int credibilityScore;
    private String status;
    private String verifiedStatus;

    /**
     * สร้าง object ข่าวลือจากข้อมูล CSV
     */
    public Rumour(String rumourId, String title, String source,
                  String createdDate, int credibilityScore,
                  String status, String verifiedStatus) {
        this.rumourId = rumourId;
        this.title = title;
        this.source = source;
        this.createdDate = createdDate;
        this.credibilityScore = credibilityScore;
        this.status = status;
        this.verifiedStatus = verifiedStatus;
    }

    /**
     * เปลี่ยนสถานะเป็น panic ถ้ารายงานเกิน threshold
     */
    public void updateStatusByReport(int reportCount) {
        if (reportCount >= 3) {
            status = "panic";
        }
    }

    /**
     * ตรวจสอบว่าข่าวถูก verify แล้วหรือยัง
     */
    public boolean isVerified() {
        return !verifiedStatus.equals("UNVERIFIED");
    }

    /**
     * กำหนดผลการตรวจสอบข่าว
     */
    public void verify(String result) {
        verifiedStatus = result;
    }

    // getters
    public String getRumourId() { return rumourId; }
    public String getTitle() { return title; }
    public String getSource() { return source; }
    public String getCreatedDate() { return createdDate; }
    public int getCredibilityScore() { return credibilityScore; }
    public String getStatus() { return status; }
    public String getVerifiedStatus() { return verifiedStatus; }
}




