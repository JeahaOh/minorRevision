package summary.java.cms.control;
import java.util.Scanner;

import summary.java.cms.dao.StudentList;
import summary.java.cms.domain.Student;


public class StudentController {
    public static Scanner keyIn;
    
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
            
            StudentList.add(s);
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

    private static void printStudents() {
        System.out.print("No.\tName\tEmail\t\tPassword\tTel\tSchool \t Major\tGraduate");
        for(int i = 0; i < StudentList.size(); i++) {
            Student s = StudentList.get(i);
            System.out.printf("\n %s : \t%s \t%s \t%s \t%s \t%s \t%s \t%b",
                    i,
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
        
        if (no < 0 || no >= StudentList.size()) {
            System.out.println("Invalid No.");
            return;
        }
        StudentList.remove(no);
        
        System.out.println("delete No...");
    }
    
    private static void detailStudent() {
        System.out.print("No. for ask : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= StudentList.size()) {
            System.out.println("Invalid No.");
            return;
        }
        Student student = StudentList.get(no);
        
        System.out.printf("\nName : %s\n", student.getName());
        System.out.printf("E-Mail : %s\n", student.getEmail());
        System.out.printf("Password : %s\n", student.getPassword());
        System.out.printf("Tel : %s\n", student.getTel());
        System.out.printf("School : %s\n", student.getSchool());
        System.out.printf("Major : %s\n", student.getMajor());
        System.out.printf("Graduate : %s\n", student.isGraduate());
    }
    
    static {
        Student s = new Student();
        s.setName("a");
        s.setEmail("a@asdf.com");
        s.setPassword("asdf1020");
        s.setTel("01010203404");
        s.setSchool("ASDF University");
        s.setMajor("JAVA");
        StudentList.add(s);
        
        s = new Student();
        s.setName("b");
        s.setEmail("b@asdf.com");
        s.setPassword("asdf1020");
        s.setTel("01034041020");
        s.setSchool("ASDF University");
        s.setMajor("C++");
        s.setGraduate(true);
        StudentList.add(s);
        
        s = new Student();
        s.setName("c");
        s.setEmail("c@asdf.com");
        s.setPassword("asdf8902");
        s.setTel("01089021020");
        s.setSchool("ASDF University");
        s.setMajor("JS");
        StudentList.add(s);
        
        s = new Student();
        s.setName("d");
        s.setEmail("d@asdf.com");
        s.setPassword("asdf8902");
        s.setTel("01034048902");
        s.setSchool("ASDF University");
        s.setMajor("C++");
        s.setGraduate(true);
        StudentList.add(s);
    }
}
