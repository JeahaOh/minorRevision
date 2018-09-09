import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import summary.java.cms.control.ManagerController;
import summary.java.cms.control.StudentController;
import summary.java.cms.control.TeacherController;
import summary.java.cms.domain.Manager;
import summary.java.cms.domain.Student;
import summary.java.cms.domain.Teacher;

public class App {
    /*
        자바 컬렉션 API사용. 
    */
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        StudentController sc = new StudentController(
                keyIn, new LinkedList<Student>());
        TeacherController tc = new TeacherController(
                keyIn, new LinkedList<Teacher>());
        ManagerController mc = new ManagerController(
                keyIn, new ArrayList<Manager>());
        
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
