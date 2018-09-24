package summary.java.cms.control.manager;
import java.util.Scanner;

import summary.java.cms.Dao.ManagerDao;
import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;

@Component
public class ManagerDeleteController {

    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {
        System.out.print("email for delete : ");
        String email = keyIn.nextLine();
        
        if (managerDao.delete(email) > 0) {
            System.out.println("Delete " + email + " is complete.");
        } else {
            System.out.println("Invalid Email.");
        }
    }
}