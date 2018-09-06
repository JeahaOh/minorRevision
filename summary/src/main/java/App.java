import java.util.Scanner;

public class App {
    
    static String[] names = new String[100];
    static String[] emails = new String[100];
    static String[] passwords = new String[100];
    static int index = 0;
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        inputMembers();
        
        printMembers();
        
        keyIn.close();
    }
    /*  메소드로 묶는것을 리팩토링이라고 함.
        alt + cmd + m
        
        static이 여기저기 붙어 있는 이유?
        main에서 인스턴스를 생성하지 않고 메소드만 불러 쓰고 있고,
        static method에서 사용되기 위해 배열 또한 static임.
    */
    static void printMembers() {
        for(int i = 0; i < index; i++) {
            System.out.printf("\n%s, %s, %s\n",
                    names[i], emails[i], passwords[i]);
        }
    }
    
    static void inputMembers() {
        while (true) {
            System.out.print("Name : ");
            names[index] = keyIn.nextLine();
            
            System.out.print("E-Mail : ");
            emails[index] = keyIn.nextLine();
            
            System.out.print("Password : ");
            passwords[index] = keyIn.nextLine();
            
            index++;
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
