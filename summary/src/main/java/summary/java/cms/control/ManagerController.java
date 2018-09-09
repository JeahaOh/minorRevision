package summary.java.cms.control;
import java.util.Scanner;


import summary.java.cms.domain.Member;

public class ManagerController {
    
    public static Scanner keyIn;
    static Manager[] managers = new Manager[3];
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
            
            if (managerIndex == managers.length) {
                increaseStorage();
            }
            
            managers[managerIndex++] = m;
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

    private static void increaseStorage() {
        Manager[] newList = new Manager[managers.length + 3];
        for (int i = 0; i < managers.length; i++) {
            newList[i] = managers[i];
        }
        managers = newList;
    }
    
    private static void printManagers() {
        int count = 0;
        System.out.print("No.\tName\tEmail\t\tPassword\tTel\t\tPosition");
        for(Manager m : managers) {
            if(count++ == managerIndex)
                break;
            System.out.printf("\n %s : \t%s \t%s \t%s \t%s \t%s",
                    count -1,
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
        
        if (no < 0 || no >= managerIndex) {
            System.out.println("Invalid No.");
            return;
        }
        
        for (int i = no; i < managerIndex - 1; i++) {
            managers[i] = managers[i + 1];
        }
        managerIndex--;
        
        System.out.println("delete No...");
    }
    
    private static void detailManager() {
        System.out.print("No. for ask : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= managerIndex) {
            System.out.println("Invalid No.");
            return;
        }
        
        System.out.printf("\nName : %s\n", managers[no].getName());
        System.out.printf("E-Mail : %s\n", managers[no].getEmail());
        System.out.printf("Password : %s\n", managers[no].getPassword());
        System.out.printf("Tel : %s\n", managers[no].getTel());
        System.out.printf("Position : %s\n", managers[no].getPosition());
    }
    
    static {
        Manager m = new Manager();
        m.setName("a");
        m.setEmail("a@asdf.com");
        m.setPassword("asdf1020");
        m.setTel("01010203404");
        m.setPosition("Ace");
        managers[managerIndex++] = m;
        
    }
}
