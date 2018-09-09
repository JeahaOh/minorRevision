package summary.java.cms.control;
import java.util.Scanner;

import summary.java.cms.domain.Member;


public class StudentController {
    public static Scanner keyIn;
    static Student[] students = new Student[100];
    static int studentIndex = 0;
    
    static class Student extends Member{
        protected String tel;
        protected String school;
        protected String major;
        protected Boolean graduate;
        
        public String getTel() {
            return tel;
        }
        public String getSchool() {
            return school;
        }
        public String getMajor() {
            return major;
        }
        public Boolean isGraduate() {
            return graduate;
        }
        
        public void setTel(String tel) {
            this.tel = tel;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public void setMajor(String major) {
            this.major = major;
        }
        public void setGraduate(Boolean graduate) {
            this.graduate = graduate;
        }
    }

    public static void serviceStudentMenu() {
        while(true) {
            System.out.print("\nStudent Management> ");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printStudents();
                //  메소드, 변수, 클래스 이름 한번에 바꾸기. alt + cnd + r
                //  refactor -> rename
            }   else if(command.equals("add")) {
                inputStudents();
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("Invalid Command..");
            }
        }
    }

    private static void printStudents() {
        int count = 0;
        System.out.print("Name\tEmail\t\tPassword\tTel\tSchool \t Major\tGraduate");
        for(Student s : students) {
            if(count++ == studentIndex)
                break;
            System.out.printf("\n%s,\t%s,\t%s,\t%s,\t%s,\t%s,\t%b",
                    s.getName(),
                    s.getEmail(),
                    s.getPassword(),
                    s.getTel(),
                    s.getSchool(),
                    s.getMajor(),
                    s.isGraduate()
                    );
        }
        System.out.println();
    }

    
    private static void inputStudents() {
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
            
            
            students[studentIndex++] = s;
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

}
