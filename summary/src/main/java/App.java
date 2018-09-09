import java.util.Scanner;

import summary.java.cms.control.ManagerController;
import summary.java.cms.control.StudentController;
import summary.java.cms.control.TeacherController;

public class App {
    /*
    List class들 통합 시킴.
    get method 사용시
    List에 어떤 객체가 있는지 확인 시켜주기 위해 명시적으로 컴파일러에게 알려줌.
    static 키워드를 지워버리고, 생성자를 통해 객체 생성,
    Scanner 객체를 전달함.
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
