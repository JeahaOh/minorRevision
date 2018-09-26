package summary.java.cms.control.teacher;

import java.util.Scanner;

import summary.java.cms.Dao.DuplicationDaoException;
import summary.java.cms.Dao.MandatoryValueDaoException;
import summary.java.cms.Dao.TeacherDao;
import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Teacher;

@Component
public class TeacherAddController {

    TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {
        while (true) {
            Teacher t = new Teacher();
            System.out.print("Name : ");
            t.setName(keyIn.nextLine());

            System.out.print("E-Mail : ");
            t.setEmail(keyIn.nextLine());

            System.out.print("Password : ");
            t.setPassword(keyIn.nextLine());

            System.out.print("Tel : ");
            t.setTel(keyIn.nextLine());

            System.out.print("pay : ");
            try {
                t.setPay(Integer.parseInt(keyIn.nextLine()));
            }   catch(Exception e) {
                System.out.println("\n!!Input Error!!\n");
                break;
            }

            System.out.print("Subject : ");
            t.setSubject(keyIn.nextLine());

            try {
                teacherDao.insert(t);
                System.out.println(t.getEmail() + " Has Saved..");
            }   catch(MandatoryValueDaoException e) {
                System.out.println("Add : Missing Required Value Error");
            }   catch(DuplicationDaoException e) {
                System.out.println("Add : Email Duplicate Error.");
                System.out.println(e.getMessage());
            }

            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
