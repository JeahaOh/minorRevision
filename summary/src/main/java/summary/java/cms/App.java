package summary.java.cms;
import java.util.LinkedList;
import java.util.Scanner;

import summary.java.cms.context.ApplicationContext;
import summary.java.cms.context.RequestMappingHandlerMapping;
import summary.java.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import summary.java.cms.domain.Student;

public class App {
/*   
    Design Patterns
    ->  현업에서 사용되고, 좋다고 이미 검증된 설계 방법 "BestPractices"를 모아둔것.
        건축에 관한 설계패턴을 소프트웨어에 접목한것.
        GoF 의 디자인 패턴 C++을 기반으로 썼고 Java예제도 있음.
    
    그중 하나.
    Command Pattern
        클래스에 메서드가 추가될 가능성이 있을 경우,
        ->  메서드 추가 하더라도 기존 클래스에 영향을 최소화 시키는 설계 기법.
        "메서드의 객체화" -> 메소드를 클래스로 정의
*/
    
    public static LinkedList<Student> students = new LinkedList<>();
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception{
        ApplicationContext iocContainer =
                new ApplicationContext("summary.java.cms.control");
        
        RequestMappingHandlerMapping requestHandlerMap = 
                new RequestMappingHandlerMapping();
        
        // => IoC Contaioner에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            //  이름으로 객체를 꺼내기.
            Object obj = iocContainer.getBean(name);
            
            //  객체에서 @RequestMapping이 붙은 베소드를 찾아 저장.
            requestHandlerMap.addMapping(obj);
        }
        
        
        while(true) {
            String menu = prompt();
            if(menu.equals("exit")) {
                System.out.println("Bye!");
                break;
            }
            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);
            if(mapping == null) {
                System.out.println("Invalid MENU..");
                continue;
            }
            
            mapping.getMethod().invoke(mapping.getInstance(), keyIn);
        }
        keyIn.close();
    }
    
    private static String prompt() {
        System.out.print("\n[MENU] > ");
        return keyIn.nextLine();
    }
}
