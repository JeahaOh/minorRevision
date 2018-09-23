package summary.java.cms.control.manager;
import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Manager;

@Component
public class ManagerDetailController {
    
    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.print("No. for ask : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= App.managers.size()) {
            System.out.println("Invalid No.");
            return;
        }
        Manager manager = (Manager) App.managers.get(no);
        
        System.out.printf("\nName : %s\n", manager.getName());
        System.out.printf("E-Mail : %s\n", manager.getEmail());
        System.out.printf("Password : %s\n", manager.getPassword());
        System.out.printf("Tel : %s\n", manager.getTel());
        System.out.printf("Position : %s\n", manager.getPosition());
    }
}
