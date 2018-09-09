package summary.java.cms.control;
import java.util.Scanner;

import summary.java.cms.domain.Member;


public class StudentController {
    public static Scanner keyIn;
    static Student[] students = new Student[5];
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
            }   else if(command.equals("add")) {
                inputStudents();
            }   else if(command.equals("delete")) {
                deleteStudent();
            }   else if(command.equals("detail")) {
                detailStudent();
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("Invalid Command..");
            }
        }
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
            
            if (studentIndex == students.length) {
                increaseStorage();
            }
            
            students[studentIndex++] = s;
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

    private static void increaseStorage() {
        Student[] newList = new Student[students.length + 3];
        for (int i = 0; i < students.length; i++) {
            newList[i] = students[i];
        }
        students = newList;
        
    }

    private static void printStudents() {
        int count = 0;
        System.out.print("No.\tName\tEmail\t\tPassword\tTel\tSchool \t Major\tGraduate");
        for(Student s : students) {
            if(count++ == studentIndex)
                break;
            System.out.printf("\n %s : \t%s \t%s \t%s \t%s \t%s \t%s \t%b",
                    count -1,
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
    
    private static void deleteStudent() {
        System.out.print("No. for delete : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= studentIndex) {
            System.out.println("Invalid No.");
            return;
        }
        
        for (int i = no; i < studentIndex - 1; i++) {
            students[i] = students[i + 1];
        }
        studentIndex--;
        
        System.out.println("delete No...");
    }
    
    private static void detailStudent() {
        System.out.print("No. for ask : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= studentIndex) {
            System.out.println("Invalid No.");
            return;
        }
        
        System.out.printf("\nName : %s\n", students[no].getName());
        System.out.printf("E-Mail : %s\n", students[no].getEmail());
        System.out.printf("Password : %s\n", students[no].getPassword());
        System.out.printf("Tel : %s\n", students[no].getTel());
        System.out.printf("School : %s\n", students[no].getSchool());
        System.out.printf("Major : %s\n", students[no].getMajor());
        System.out.printf("Graduate : %s\n", students[no].isGraduate());
    }
    
    static {
        Student s = new Student();
        s.setName("a");
        s.setEmail("a@asdf.com");
        s.setPassword("asdf1020");
        s.setTel("01010203404");
        s.setSchool("ASDF University");
        s.setMajor("JAVA");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("b");
        s.setEmail("b@asdf.com");
        s.setPassword("asdf1020");
        s.setTel("01034041020");
        s.setSchool("ASDF University");
        s.setMajor("C++");
        s.setGraduate(true);
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("c");
        s.setEmail("c@asdf.com");
        s.setPassword("asdf8902");
        s.setTel("01089021020");
        s.setSchool("ASDF University");
        s.setMajor("JS");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("d");
        s.setEmail("d@asdf.com");
        s.setPassword("asdf8902");
        s.setTel("01034048902");
        s.setSchool("ASDF University");
        s.setMajor("C++");
        s.setGraduate(true);
        students[studentIndex++] = s;
    }

}
