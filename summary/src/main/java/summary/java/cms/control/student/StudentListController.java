package summary.java.cms.control.student;

import java.util.List;
import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Student;

@Component
public class StudentListController {
    
    @RequestMapping("student/list")
    public void list(Scanner keyIn) {
        List<Student> list = App.studentDao.findAll();
        
        System.out.print("Name\tEmail\t\tTel");
        for(Student s : list) {
            System.out.printf("\n%s \t%s \t%s",
                    s.getName(),
                    s.getEmail(),
                    s.getTel()
                    );
        }
        System.out.println();
    }
}