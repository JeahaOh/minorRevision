package summary.java.cms.control.teacher;

import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Teacher;

@Component
public class TeacherListController {
    
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        System.out.print("No.\tName\tEmail\t\tTel\t\t Subject");
        for(int i = 0; i < App.teachers.size(); i++) {
            Teacher t = App.teachers.get(i);
            System.out.printf("\n %s : \t%s \t%s \t%s \t[%s]",
                    i,
                    t.getName(),
                    t.getEmail(),
                    t.getTel(),
                    t.getSubject()
                    );
        }
        System.out.println();
    }
}
