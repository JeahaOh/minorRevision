package summary.java.cms.control.teacher;

import java.util.Scanner;

import summary.java.cms.App;
import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.domain.Teacher;

@Component
public class TeacherAddController {
    
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
                System.out.println("\n!!급여항목 입력 오류!!\n");
                break;
            }
            
            System.out.print("Subject : ");
            t.setSubject(keyIn.nextLine());
            
            App.teachers.add(t);
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    {
        Teacher t = new Teacher();
        t.setName("qwer");
        t.setEmail("aqwer@asdf.com");
        t.setPassword("asdfqwer");
        t.setTel("01089028902");
        t.setPay(1000);
        t.setSubject("Java, C, C++");
        App.teachers.add(t);
    }
}
