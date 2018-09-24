package summary.java.cms.control.teacher;

import java.util.Scanner;

import summary.java.cms.Dao.TeacherDao;
import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("email for delete : ");
        String email = keyIn.nextLine();
        
        if (teacherDao.delete(email) > 0) {
            System.out.println("Delete " + email + " is complete.");
        } else {
            System.out.println("Invalid Email.");
        }
    }
}
