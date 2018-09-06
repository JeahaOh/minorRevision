import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
     // 1) 키보드 입력을 처리할 객체
        Scanner keyIn = new Scanner(System.in);
        
        // 2) 사용자로부터 회원 정보 입력 받아 출력하
        while (true) {
            System.out.print("Name : ");
            String name = keyIn.nextLine();
            
            System.out.print("E-Mail : ");
            String email = keyIn.nextLine();
            
            System.out.print("Password : ");
            String password = keyIn.nextLine();
            System.out.printf("\n%s, %s, %s\n", name, email, password);
            
            System.out.print("\nContinue? [Y/n] ");
            //  y없이 엔터만 쳐도 루프를 탈출하지 않으면 Y
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
