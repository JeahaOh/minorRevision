package summary.java.cms.control.student;

import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Student;

@Component
public class StudentAddController {
    
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
            
            if (App.studentDao.insert(s) > 0) {
                System.out.println("저장하였습니다.");
            } else {
                System.out.println("같은 이메일의 학생이 존재합니다.");
            }
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    {   //  구조에 따라, 어디에 붙이느냐에 따라 static 이였다가 Instance였다 함.
        Student s = new Student();
        s.setName("a");
        s.setEmail("a@asdf.com");
        s.setPassword("asdf1020");
        s.setTel("01010203404");
        s.setSchool("ASDF University");
        s.setMajor("JAVA");
        App.studentDao.insert(s);
        
        s = new Student();
        s.setName("b");
        s.setEmail("b@asdf.com");
        s.setPassword("asdf1020");
        s.setTel("01034041020");
        s.setSchool("ASDF University");
        s.setMajor("C++");
        s.setGraduate(true);
        App.studentDao.insert(s);
        
        s = new Student();
        s.setName("c");
        s.setEmail("c@asdf.com");
        s.setPassword("asdf8902");
        s.setTel("01089021020");
        s.setSchool("ASDF University");
        s.setMajor("JS");
        App.studentDao.insert(s);
        
        s = new Student();
        s.setName("d");
        s.setEmail("d@asdf.com");
        s.setPassword("asdf8902");
        s.setTel("01034048902");
        s.setSchool("ASDF University");
        s.setMajor("C++");
        s.setGraduate(true);
        App.studentDao.insert(s);
    }
}
