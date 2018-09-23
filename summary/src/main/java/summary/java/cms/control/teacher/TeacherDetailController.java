package summary.java.cms.control.teacher;

import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    
    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("No. for ask : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= App.teachers.size()) {
            System.out.println("Invalid No.");
            return;
        }
        Teacher teacher = App.teachers.get(no);
        
        System.out.printf("\nName : %s\n", teacher.getName());
        System.out.printf("E-Mail : %s\n", teacher.getEmail());
        System.out.printf("Password : %s\n", teacher.getPassword());
        System.out.printf("Tel : %s\n", teacher.getTel());
        System.out.printf("Pay : %d\n", teacher.getPay());
        System.out.printf("Subject : %s\n", teacher.getSubject());
    }
}
