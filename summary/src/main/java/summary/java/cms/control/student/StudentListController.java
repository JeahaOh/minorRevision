package summary.java.cms.control.student;

import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Student;

@Component
public class StudentListController {
    
    @RequestMapping("student/list")
    public void list(Scanner keyIn) {
        System.out.print("No.\tName\tEmail\t\tTel");
        for(int i = 0; i < App.students.size(); i++) {
            Student s = App.students.get(i);
            System.out.printf("\n %s : \t%s \t%s \t%s",
                    i,
                    s.getName(),
                    s.getEmail(),
                    s.getTel()
                    );
        }
        System.out.println();
    }
}
