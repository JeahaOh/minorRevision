package summary.java.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import summary.java.cms.Dao.TeacherDao;
import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Teacher;

@Component
public class TeacherListController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        List<Teacher> list = teacherDao.findAll();
        
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
