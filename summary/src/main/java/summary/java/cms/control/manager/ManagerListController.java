package summary.java.cms.control.manager;
import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Manager;

@Component
public class ManagerListController {
    
    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        System.out.print("No.\tName\tEmail\t\tPassword\tTel\t\tPosition");
        for(int i = 0; i < App.managers.size(); i++) {
            Manager m = (Manager) App.managers.get(i);
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
}
