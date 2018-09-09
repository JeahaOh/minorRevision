package summary.java.cms.control;
import java.util.Scanner;

import summary.java.cms.domain.Member;

public class TeacherController {
    public static Scanner keyIn;
    static Teacher[] teachers = new Teacher[3];
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
            
            if (teacherIndex == teachers.length) {
                increaseStorage();
            }
            
            teachers[teacherIndex++] = t;
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

    
    
    private static void increaseStorage() {
        Teacher[] newList = new Teacher[teachers.length + 3];
        for (int i = 0; i < teachers.length; i++) {
            newList[i] = teachers[i];
        }
        teachers = newList;
    }

    private static void printTeachers() {
        int count = 0;
        System.out.print("No.\tName\tEmail\t\tPassword\tTel\t\tPay \t Subject");
        for(Teacher t : teachers) {
            if(count++ == teacherIndex)
                break;
            System.out.printf("\n %s : \t%s \t%s \t%s \t%s \t%d \t[%s]",
                    count -1,
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
    
    private static void deleteTeacher() {
        System.out.print("No. for delete : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teacherIndex) {
            System.out.println("Invalid No.");
            return;
        }
        
        for (int i = no; i < teacherIndex - 1; i++) {
            teachers[i] = teachers[i + 1];
        }
        teacherIndex--;
        
        System.out.println("delete No...");
    }
    
    private static void detailTeacher() {
        System.out.print("No. for ask : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teacherIndex) {
            System.out.println("Invalid No.");
            return;
        }
        
        System.out.printf("\nName : %s\n", teachers[no].getName());
        System.out.printf("E-Mail : %s\n", teachers[no].getEmail());
        System.out.printf("Password : %s\n", teachers[no].getPassword());
        System.out.printf("Tel : %s\n", teachers[no].getTel());
        System.out.printf("Pay : %d\n", teachers[no].getPay());
        System.out.printf("Subject : %s\n", teachers[no].getSubject());
    }
    
    static {
        Teacher t = new Teacher();
        t.setName("qwer");
        t.setEmail("aqwer@asdf.com");
        t.setPassword("asdfqwer");
        t.setTel("01089028902");
        t.setPay(1000);
        t.setSubject("Java, C, C++");
        teachers[teacherIndex++] = t;
        
    }
}
