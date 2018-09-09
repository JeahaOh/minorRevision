import java.util.Scanner;

import summary.java.cms.context.ApplicationContext;
import summary.java.cms.control.Controller;

public class App {
    /*
        ApplicationContext를 만들어서 클래스를 따로 빼는건 목잡하지만 유지 보수가 더 쉬워짐.
        이것이 SpringFrameWork의 일부를 따라한것임.
    */
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception{
        ApplicationContext iocContainer
        = new ApplicationContext("summary.java.cms.control");
        
        while(true) {
            String menu = promptMenu();
            if(menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
            Controller controller = (Controller)iocContainer.getBean(menu);
            if(controller != null) {
                controller.service(keyIn);
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
        System.out.print("MENU No.> ");
        return keyIn.nextLine();
    }
}
