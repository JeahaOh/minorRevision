package summary.java.cms.control.student;

import java.util.Scanner;

import summary.java.cms.Dao.DuplicationDaoException;
import summary.java.cms.Dao.MandatoryValueDaoException;
import summary.java.cms.Dao.StudentDao;
import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Student;

@Component
public class StudentAddController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while (true) {
            Student s = new Student();
            
            System.out.print("Name : ");
            s.setName(keyIn.nextLine());
            
            System.out.print("E-Mail : ");
            s.setEmail(keyIn.nextLine());
            
            System.out.print("Password : ");
            s.setPassword(keyIn.nextLine());
            
            System.out.print("Tel : ");
            s.setTel(keyIn.nextLine());
            
            System.out.print("School : ");
            s.setSchool(keyIn.nextLine());
            
            System.out.print("Major : ");
            s.setMajor(keyIn.nextLine());
            
            System.out.print("Graduate : ");
            s.setGraduate(Boolean.parseBoolean(keyIn.nextLine()));
           
            try {
                studentDao.insert(s);
                System.out.println(s.getEmail() + " Has Saved..");
            }   catch(MandatoryValueDaoException e) {
                System.out.println("Add : Missing Required Value Error");
            }   catch(DuplicationDaoException e) {
                System.out.println("Add : The Email is already Exist.");
                System.out.println(e.getMessage());
            }
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}