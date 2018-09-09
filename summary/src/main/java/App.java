import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import summary.java.cms.control.Controller;
import summary.java.cms.control.ManagerController;
import summary.java.cms.control.StudentController;
import summary.java.cms.control.TeacherController;
import summary.java.cms.domain.Manager;
import summary.java.cms.domain.Student;
import summary.java.cms.domain.Teacher;

public class App {
    /*
        Controller의 호출 규칙을 interface로 재정의.
        Scanner 객체를 호출시 받아 사용.
        
        HashMap으로 Controller객체 저장, 불러오는 방식을 더 간단하게 만들었음.
        if문을 not 조건을 걸어서 예외처리를 더 간단하게 한것을 볼수 있음. 
    */
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        HashMap<String, Controller> requestHandlerMapping = new HashMap<>();
        requestHandlerMapping.put
        ("1", new StudentController(new LinkedList<Student>()));
        requestHandlerMapping.put
        ("2", new TeacherController(new LinkedList<Teacher>()));
        requestHandlerMapping.put
        ("3", new ManagerController(new LinkedList<Manager>()));
        //  HashMap에 .
        //  Controller 객체들을 이름 붙여 저장함.
        
        while(true) {
            String menu = promptMenu();
            if(menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
            Controller controller = requestHandlerMapping.get(menu);
            if(controller != null) {
                controller.service(keyIn);
                //  controller를 불러오는 방법에 주목.
            }   else {
                System.out.println("Invalid Menu.");
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
