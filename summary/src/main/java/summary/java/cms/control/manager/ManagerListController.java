package summary.java.cms.control.manager;
import java.util.List;
import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Manager;

@Component
public class ManagerListController {
    
    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        List<Manager> list = App.managerDao.findAll();
        
        System.out.print("Name\tEmail\t\tTel");
        for(Manager m : list) {
            System.out.printf("\n%s \t%s \t%s",
                    m.getName(),
                    m.getEmail(),
                    m.getTel()
                    );
        }
        System.out.println();
    }
}
