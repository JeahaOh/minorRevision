package summary.java.cms.control.manager;
import java.util.Scanner;

import summary.java.cms.Dao.ManagerDao;
import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Manager;

@Component
public class ManagerDetailController {

    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.print("email for ask : ");
        String email = keyIn.nextLine();
        Manager manager = managerDao.findByEmail(email);
        
        if (manager == null) {
            System.out.println("Invalid Email");
            return;
        }
        
        System.out.printf("\nName : %s\n", manager.getName());
        System.out.printf("E-Mail : %s\n", manager.getEmail());
        System.out.printf("Password : %s\n", manager.getPassword());
        System.out.printf("Tel : %s\n", manager.getTel());
        System.out.printf("Position : %s\n", manager.getPosition());
    }
}
