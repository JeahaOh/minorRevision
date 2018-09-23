import java.util.Scanner;

import summary.java.cms.context.ApplicationContext;
import summary.java.cms.context.RequestMappingHandlerMapping;
import summary.java.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {
    /*
        Annotation활용.
        RequestMapping을 통해 메소드 호출.

        ApplicationContext에서 객체를 저장.
        Component와 RequestMapping 두개의 어노테이션을 통해서 객체를 생성,
        RequestMappingHandlerMapping 객체의 명령어를 저장함.
        @RequestMapping 얘를 key값으로 메소드를 불러옴ㅇㅇ 시발 어렵네.
        
        남이 짠 코드에 쫄지 말라.
        객체지향 잘 하는방법, 짜여진 코드가 무슨일을 하는지 이해를 먼저 하라.
    */
    
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
        System.out.println("\n[MENU]");
        System.out.print("MENU > ");
        return keyIn.nextLine();
    }
}
