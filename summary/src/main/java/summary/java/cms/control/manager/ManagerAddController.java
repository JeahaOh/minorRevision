package summary.java.cms.control.manager;
import java.util.Scanner;

import summary.java.cms.Dao.ManagerDao;
import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Manager;

@Component
public class ManagerAddController {
    
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
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
            
            int rtval = 0;
            if((rtval = managerDao.insert(m)) > 0) {
                System.out.println("Saved");
            }   else if(rtval == -1) {
                System.out.println("Same email adress is already exist.");
            }   else {
                System.out.println("Some Error Occured.");
            }
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
