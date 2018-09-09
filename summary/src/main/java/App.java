import java.util.Scanner;

import summary.java.cms.control.ManagerController;
import summary.java.cms.control.StudentController;
import summary.java.cms.control.TeacherController;

public class App {
    /*
    ArrayList class에 Generic 사용으로
    명시적으로 데이터 타입을 표현한것을 떼어줌. 
    */
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        StudentController sc = new StudentController(keyIn);
        TeacherController tc = new TeacherController(keyIn);
        ManagerController mc = new ManagerController(keyIn);
        
        while(true) {
            String menu = promptMenu();
            
            if(menu.equals("1")) {
                sc.serviceStudentMenu();
            }   else if(menu.equals("2")){
                tc.serviceTeacherMenu();
            }   else if(menu.equals("3")){
                mc.serviceManagerMenu();
            }   else if(menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
        }
        keyIn.close();
    }
    
    private static String promptMenu() {
        System.out.println("[MENU]");
        System.out.println("1. Student Info Management");
        System.out.println("2. Teacher Info Management");
        System.out.println("3. Manager Info Management");
        System.out.println("0. EXIT");
        
        while (true) {
            System.out.print("MENU No.> ");
            
            String menu = keyIn.nextLine();
            
            switch (menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("Invalid No.");
            }
        }
    }
}
