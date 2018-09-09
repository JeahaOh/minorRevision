package summary.java.cms.control;
import java.util.Scanner;

import summary.java.cms.dao.ManagerList;
import summary.java.cms.domain.Manager;

public class ManagerController {
    public static Scanner keyIn;
    
    public static void serviceManagerMenu() {
        while(true) {
            System.out.print("\nManager Management> ");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printManagers();
            }   else if(command.equals("add")) {
                inputManagers();
            }   else if(command.equals("delete")) {
                deleteManager();
            }   else if(command.equals("detail")) {
                detailManager();
            }      else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("Invalid Command..");
            }
        }
    }
    
    private static void inputManagers() {
        while (true) {
            Manager m = new Manager();
            System.out.print("Name : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("E-Mail : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("Password : ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("Tel : ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("Position : ");
            m.setPosition(keyIn.nextLine());
            
            ManagerList.add(m);
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    private static void printManagers() {
        System.out.print("No.\tName\tEmail\t\tPassword\tTel\t\tPosition");
        for(int i = 0; i < ManagerList.size(); i++) {
            Manager m = ManagerList.get(i);
            System.out.printf("\n %s : \t%s \t%s \t%s \t%s \t%s",
                    i,
                    m.getName(),
                    m.getEmail(),
                    m.getPassword(),
                    m.getTel(),
                    m.getPosition()
                    );
        }
        System.out.println();
    }
    
    private static void deleteManager() {
        System.out.print("No. for delete : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= ManagerList.size()) {
            System.out.println("Invalid No.");
            return;
        }
        ManagerList.remove(no);
        
        System.out.println("delete No...");
    }
    
    private static void detailManager() {
        System.out.print("No. for ask : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= ManagerList.size()) {
            System.out.println("Invalid No.");
            return;
        }
        Manager manager = ManagerList.get(no);
        
        System.out.printf("\nName : %s\n", manager.getName());
        System.out.printf("E-Mail : %s\n", manager.getEmail());
        System.out.printf("Password : %s\n", manager.getPassword());
        System.out.printf("Tel : %s\n", manager.getTel());
        System.out.printf("Position : %s\n", manager.getPosition());
    }
    
    static {
        Manager m = new Manager();
        m.setName("a");
        m.setEmail("a@asdf.com");
        m.setPassword("asdf1020");
        m.setTel("01010203404");
        m.setPosition("Ace");
        ManagerList.add(m);
    }
}
