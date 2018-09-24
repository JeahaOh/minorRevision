package summary.java.cms.control.student;

import java.util.Scanner;

import summary.java.cms.Dao.StudentDao;
import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Student;

@Component
public class StudentDetailController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/detail")
    public void detail(Scanner keyIn) {
        System.out.print("email for ask : ");
        String email = keyIn.nextLine();
        Student student = studentDao.findByEmail(email);
        
        if (student == null) {
            System.out.println("Invalid Email");
            return;
        }
        
        System.out.printf("\nName : %s\n", student.getName());
        System.out.printf("E-Mail : %s\n", student.getEmail());
        System.out.printf("Password : %s\n", student.getPassword());
        System.out.printf("Tel : %s\n", student.getTel());
        System.out.printf("School : %s\n", student.getSchool());
        System.out.printf("Major : %s\n", student.getMajor());
        System.out.printf("Graduate : %s\n", student.isGraduate());
    }
}