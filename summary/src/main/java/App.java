import java.util.Scanner;

import summary.java.cms.control.ManagerController;
import summary.java.cms.control.StudentController;
import summary.java.cms.control.TeacherController;
import summary.java.cms.domain.Manager;
import summary.java.cms.domain.Student;
import summary.java.cms.domain.Teacher;
import summary.java.cms.util.ArrayList;
import summary.java.cms.util.LinkedList;

public class App {
    /*
        List util에 List Interface 적용,
        default method 적용.
        
        private List<T> obj; 
        interface를 사용함으로 객체를 저장할 List의 타입이 조금 더 유연해짐
        Controller를 호출하는곳에서 List 객체를 정할 수 있게됨,
        생성자로 List객체를 받아 사용.
        
        객체 생성을 해야 객체를 담을 수 있으므로 static 블럭을 init method화 해서,
        객체 생성시 init method 호출. 
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
