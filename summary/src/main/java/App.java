import java.util.Scanner;

public class App {
    
    // 여러 속성의 값을 관리하기 쉽도록,
    //  클래스(사용자 정의 데이터 타입)를 만들어 사용한다.
    static class Member {
        protected String name;
        protected String email;
        protected String password;
        
        
        // 인스턴스의 메모리를 다루는
        //  setter/getter   = operator=accessor=property=message
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
    
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
    
    static class Manager extends Member{
        protected String tel;
        protected String position;
        
        public String getTel() {
            return tel;
        }
        public String getPosition() {
            return position;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public void setPosition(String position) {
            this.position = position;
        }
    }
    
    static Student[] students = new Student[100];
    static Teacher[] teachers = new Teacher[100];
    static Manager[] managers = new Manager[100];
    static int studentIndex = 0;
    static int teacherIndex = 0;
    static int managerIndex = 0;
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        while(true) {
            String menu = promptMenu();
            //  변수를 메소드를 실행해서 가져온다. 신박.
            
            if(menu.equals("1")) {
                serviceStudentMenu();
            }   else if(menu.equals("2")){
                serviceTeacherMenu();
            }   else if(menu.equals("3")){
                serviceManagerMenu();
            }   else if(menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
        }
        keyIn.close();
    }

    private static String promptMenu() {
        System.out.println("[MENU]");
        System.out.println("1. Student Info Management");
        System.out.println("2. Teacher Info Management");
        System.out.println("3. Manager Info Management");
        System.out.println("0. EXIT");
        
        while (true) {
            System.out.print("MENU No.> ");
            
            String menu = keyIn.nextLine();
            
            switch (menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("Invalid No.");
            }
        }   // 실질적 메인 메뉴. switch문의 형태와 입력받은 변수를 고대로 return한다는것 인지!
    }

    private static void serviceStudentMenu() {
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

    private static void serviceTeacherMenu() {
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
    
    private static void serviceManagerMenu() {
        while(true) {
            System.out.print("\nManager Management> ");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printManagers();
            }   else if(command.equals("add")) {
                inputManagers();
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("Invalid Command..");
            }
        }
    }

    static void printStudents() {
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
    
    static void printTeachers() {
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
    
    static void printManagers() {
        int count = 0;
        System.out.print("Name\tEmail\t\tPassword\tTel\t\tPosition");
        for(Manager m : managers) {
            if(count++ == managerIndex)
                break;
            System.out.printf("\n%s,\t%s,\t%s,\t%s,\t%s",
                    m.getName(),
                    m.getEmail(),
                    m.getPassword(),
                    m.getTel(),
                    m.getPosition()
                    );
        }
        System.out.println();
    }
    
    static void inputStudents() {
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
    
    static void inputTeachers() {
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
    
    static void inputManagers() {
        while (true) {
            Manager m = new Manager();
            System.out.print("Name : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("E-Mail : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("Password : ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("Tel : ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("Position : ");
            m.setPosition(keyIn.nextLine());
            
            managers[managerIndex++] = m;
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

}
