package summary.java.cms.control.manager;
import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;

@Component
public class ManagerDeleteController {
    
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {
        System.out.print("email for delete : ");
        String email = keyIn.nextLine();
        
        if (App.managerDao.delete(email) > 0) {
            System.out.println("Delete" + email + "is complete.");
        } else {
            System.out.println("Invalid Email.");
        }
    }
}