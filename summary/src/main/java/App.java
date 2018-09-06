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
    
    static Member[] members = new Member[100];
    //  Member 객체를 저장하는 배열.
    static int index = 0;
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        inputMembers();
        
        printMembers();
        
        keyIn.close();
    }

    static void printMembers() {
        for(int i = 0; i < index; i++) {
            System.out.printf("\n%s, %s, %s\n",
                    members[i].getName(),
                    members[i].getEmail(),
                    members[i].getPassword());
        }
    }
    
    static void inputMembers() {
        while (true) {
            Member m = new Member();
            System.out.print("Name : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("E-Mail : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("Password : ");
            m.setPassword(keyIn.nextLine());
            
            members[index++] = m;
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
