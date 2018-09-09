import java.util.Scanner;

import summary.java.cms.control.ManagerController;
import summary.java.cms.control.StudentController;
import summary.java.cms.control.TeacherController;

public class App {
    /*  
        Controller class 들의 부피가 커져서,
        객체 클래스(domain)와 객체 관리 클래스(control), 객체 저장공간 클래스(List)로
        각각 분리시킴.
    */
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        StudentController.keyIn = keyIn;
        TeacherController.keyIn = keyIn;
        ManagerController.keyIn = keyIn;
        
        while(true) {
            String menu = promptMenu();
            
            if(menu.equals("1")) {
                StudentController.serviceStudentMenu();
            }   else if(menu.equals("2")){
                TeacherController.serviceTeacherMenu();
            }   else if(menu.equals("3")){
                ManagerController.serviceManagerMenu();
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
