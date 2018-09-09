import java.util.Scanner;

public class App {
    /*  학생, 강사, 매니져의 관리가 쉽도록,
        멤버변수와 메소드들을 각각 클래스로 쪼개고,
        static 키워드로 App class에서 접근할 수 있도록 함.
        class이름.변수이름
        class이름.메소드 로 접근이 가능함.
        main이 심플해짐.
        
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
