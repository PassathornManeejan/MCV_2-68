package src.model;

/**
 * Model ผู้ใช้งานระบบ
 */
public class User {

    private String userId;
    private String name;
    private String role;

    /**
     * สร้างผู้ใช้จากข้อมูล CSV
     */
    public User(String userId, String name, String role) {
        this.userId = userId;
        this.name = name;
        this.role = role;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getRole() { return role; }
}


