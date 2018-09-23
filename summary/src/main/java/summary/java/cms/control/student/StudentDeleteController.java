package summary.java.cms.control.student;

import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;

@Component
public class StudentDeleteController {
    
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("No. for delete : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= App.students.size()) {
            System.out.println("Invalid No.");
            return;
        }
        App.students.remove(no);
        
        System.out.println("delete No...");
    }
}
