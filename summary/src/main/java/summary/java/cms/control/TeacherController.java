package summary.java.cms.control;
import java.util.Scanner;

import summary.java.cms.domain.Teacher;
import summary.java.cms.util.LinkedList;

public class TeacherController {
    public Scanner keyIn;
    private LinkedList<Teacher> teachers = new LinkedList<>();
    
    public TeacherController(Scanner keyIn) {
        this.keyIn = keyIn;
    }

    public void serviceTeacherMenu() {
        while(true) {
            System.out.print("\nTeacher Management> ");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printTeachers();
            }   else if(command.equals("add")) {
                inputTeachers();
            }   else if(command.equals("delete")) {
                deleteTeacher();
            }   else if(command.equals("detail")) {
                detailTeacher();
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("Invalid Command..");
            }
        }
    }
    
    private void inputTeachers() {
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
            t.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("Subject : ");
            t.setSubject(keyIn.nextLine());
            
            teachers.add(t);
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    private void printTeachers() {
        System.out.print("No.\tName\tEmail\t\tPassword\tTel\t\tPay \t Subject");
        for(int i = 0; i < teachers.size(); i++) {
            Teacher t = teachers.get(i);
            System.out.printf("\n %s : \t%s \t%s \t%s \t%s \t%d \t[%s]",
                    i,
                    t.getName(),
                    t.getEmail(),
                    t.getPassword(),
                    t.getTel(),
                    t.getPay(),
                    t.getSubject()
                    );
        }
        System.out.println();
    }
    
    private void deleteTeacher() {
        System.out.print("No. for delete : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teachers.size()) {
            System.out.println("Invalid No.");
            return;
        }
        teachers.remove(no);
        
        System.out.println("delete No...");
    }
    
    private void detailTeacher() {
        System.out.print("No. for ask : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teachers.size()) {
            System.out.println("Invalid No.");
            return;
        }
        Teacher teacher = teachers.get(no);
        
        System.out.printf("\nName : %s\n", teacher.getName());
        System.out.printf("E-Mail : %s\n", teacher.getEmail());
        System.out.printf("Password : %s\n", teacher.getPassword());
        System.out.printf("Tel : %s\n", teacher.getTel());
        System.out.printf("Pay : %d\n", teacher.getPay());
        System.out.printf("Subject : %s\n", teacher.getSubject());
    }
    
    {
        Teacher t = new Teacher();
        t.setName("qwer");
        t.setEmail("aqwer@asdf.com");
        t.setPassword("asdfqwer");
        t.setTel("01089028902");
        t.setPay(1000);
        t.setSubject("Java, C, C++");
        teachers.add(t);
    }
}
