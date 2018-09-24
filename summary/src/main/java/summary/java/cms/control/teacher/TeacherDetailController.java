package summary.java.cms.control.teacher;

import java.util.Scanner;

import summary.java.cms.Dao.TeacherDao;
import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("email for ask : ");
        String email = keyIn.nextLine();
        Teacher teacher = teacherDao.findByEmail(email);
        
        if (teacher == null) {
            System.out.println("Invalid Email");
            return;
        }
        
        System.out.printf("\nName : %s\n", teacher.getName());
        System.out.printf("E-Mail : %s\n", teacher.getEmail());
        System.out.printf("Password : %s\n", teacher.getPassword());
        System.out.printf("Tel : %s\n", teacher.getTel());
        System.out.printf("Pay : %d\n", teacher.getPay());
        System.out.printf("Subject : %s\n", teacher.getSubject());
    }
}
