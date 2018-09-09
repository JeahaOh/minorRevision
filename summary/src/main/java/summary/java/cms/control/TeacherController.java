package summary.java.cms.control;
import java.util.Scanner;

import summary.java.cms.domain.Member;

public class TeacherController {
    public static Scanner keyIn;
    static Teacher[] teachers = new Teacher[100];
    static int teacherIndex = 0;
    
    static class Teacher extends Member {
        protected String tel;
        protected int pay;
        protected String subject;
        
        public String getTel() {
            return tel;
        }
        public int getPay() {
            return pay;
        }
        public String getSubject() {
            return subject;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public void setSubject(String subject) {
            this.subject = subject;
        }
    }

    public static void serviceTeacherMenu() {
        while(true) {
            System.out.print("\nTeacher Management> ");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printTeachers();
            }   else if(command.equals("add")) {
                inputTeachers();
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("Invalid Command..");
            }
        }
    }
    
    private static void inputTeachers() {
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
            
            teachers[teacherIndex++] = t;
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

    
    
    private static void printTeachers() {
        int count = 0;
        System.out.print("Name\tEmail\t\tPassword\tTel\t\tPay \t Subject");
        for(Teacher t : teachers) {
            if(count++ == teacherIndex)
                break;
            System.out.printf("\n%s,\t%s,\t%s,\t%s,\t%d,\t[%s]",
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
    
    
}
