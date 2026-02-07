package src;

import src.controller.RumourController;
import src.view.LoginView;

/**
 * Program entry point
 * เปิดหน้า Login เป็นหน้าจอแรกของระบบ
 */
public class Main {
    public static void main(String[] args) {
        RumourController controller = new RumourController();
        new LoginView(controller);
    }
}



