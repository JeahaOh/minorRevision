package summary.java.cms.control.manager;
import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Manager;

@Component
public class ManagerAddController {
    
    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
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
            
            if (App.managerDao.insert(m) > 0) {
                System.out.println("Saved.");
            } else {
                System.out.println("The Email is already Exist.");
            }
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    {
        Manager m = new Manager();
        m.setName("a");
        m.setEmail("a@asdf.com");
        m.setPassword("asdf1020");
        m.setTel("01010203404");
        m.setPosition("Ace");
        App.managerDao.insert(m);
    }
}
