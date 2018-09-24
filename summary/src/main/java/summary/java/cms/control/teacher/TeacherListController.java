package summary.java.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Teacher;

@Component
public class TeacherListController {
    
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        List<Teacher> list = App.teacherDao.findAll();
        
        System.out.print("Name\tEmail\t\tTel");
        for(Teacher t : list) {
            System.out.printf("\n%s \t%s \t%s \t[%s]",
                    t.getName(),
                    t.getEmail(),
                    t.getTel(),
                    t.getSubject()
                    );
        }
        System.out.println();
    }
}
