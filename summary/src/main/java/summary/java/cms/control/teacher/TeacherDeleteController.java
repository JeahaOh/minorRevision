package summary.java.cms.control.teacher;

import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {
    
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("No. for delete : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= App.teachers.size()) {
            System.out.println("Invalid No.");
            return;
        }
        App.teachers.remove(no);
        
        System.out.println("delete No...");
    }
}
