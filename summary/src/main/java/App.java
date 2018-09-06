import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        String[] names = new String[100];
        String[] emails = new String[100];
        String[] passwords = new String[100];
        //  각 정보를 100개씩 저장하는 배열 생성.
        
        int index = 0;
        //  배열들의 인덱스를 한번에 관리.
        
        Scanner keyIn = new Scanner(System.in);
        
        while (true) {
            //  입력받아 각 배열에 저장.
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
        for(int i = 0; i < index; i++) {
            System.out.printf("\n%s, %s, %s\n",
                    names[i], emails[i], passwords[i]);
            
        }
        
        keyIn.close();
    }
}
