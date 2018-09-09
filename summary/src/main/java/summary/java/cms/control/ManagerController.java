package summary.java.cms.control;
import java.util.Scanner;

import summary.java.cms.domain.Member;

public class ManagerController {
    
    public static Scanner keyIn;
    static Manager[] managers = new Manager[100];
    static int managerIndex = 0;
    
    
    static class Manager extends Member{
        protected String tel;
        protected String position;
        
        public String getTel() {
            return tel;
        }
        public String getPosition() {
            return position;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public void setPosition(String position) {
            this.position = position;
        }
    }
    
    public static void serviceManagerMenu() {
        while(true) {
            System.out.print("\nManager Management> ");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printManagers();
            }   else if(command.equals("add")) {
                inputManagers();
            }   else if(command.equals("quit")) {
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
            
            managers[managerIndex++] = m;
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

    private static void printManagers() {
        int count = 0;
        System.out.print("Name\tEmail\t\tPassword\tTel\t\tPosition");
        for(Manager m : managers) {
            if(count++ == managerIndex)
                break;
            System.out.printf("\n%s,\t%s,\t%s,\t%s,\t%s",
                    m.getName(),
                    m.getEmail(),
                    m.getPassword(),
                    m.getTel(),
                    m.getPosition()
                    );
        }
        System.out.println();
    }
}
