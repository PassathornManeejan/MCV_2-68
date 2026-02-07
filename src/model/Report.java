package src.model;

/**
 * Model การรายงานข่าว
 */
public class Report {

    private String reportId;
    private String userId;
    private String rumourId;
    private String reportDate;
    private String reportType;

    /**
     * สร้างข้อมูลการรายงานข่าว
     */
    public Report(String reportId, String userId,
                  String rumourId, String reportDate,
                  String reportType) {
        this.reportId = reportId;
        this.userId = userId;
        this.rumourId = rumourId;
        this.reportDate = reportDate;
        this.reportType = reportType;
    }

    public String getUserId() { return userId; }
    public String getRumourId() { return rumourId; }
}



