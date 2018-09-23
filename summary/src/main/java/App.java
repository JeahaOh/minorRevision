import java.lang.reflect.Method;
import java.util.Scanner;

import summary.java.cms.annotation.RequestMapping;
import summary.java.cms.context.ApplicationContext;

public class App {
    /*
        Annotation활용.
        RequestMapping을 통해 메소드 호출.

        Component와 RequestMapping 두개의 어노테이션을 통해서 객체를 생성,
        Component 어노테이션의 student, teacher, manager으로 클래스를 호출해서
        RequestMapping으로 메소드들을 실행시킴.
    */
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception{
        ApplicationContext iocContainer
        = new ApplicationContext("summary.java.cms.control");
        
        while(true) {
            String menu = prompt();
            if(menu.equals("exit")) {
                System.out.println("Bye!");
                break;
            }
            Object controller = iocContainer.getBean(menu);
            if(controller == null) {
                System.out.println("Invalid MENU..");
                continue;
            }   
            Method method = findByRequestMapping(controller.getClass());
            if(method == null) {
                System.out.println("Invalid MENU..");
                continue;
            }
            
            method.invoke(controller, keyIn);
            
        }
        keyIn.close();
    }
    
    private static Method findByRequestMapping(Class<?> clazz) {

        // => 인자로 받은 클래스의 메소드 목록을 꺼낸다.
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods) {
            
            // => 메소드에서 @ReauestMapping 정보를 추출한다.
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            
            if(anno != null) {
                //  찾았다면 메소드를 리턴.
                return m;
            }
            
        }
        return null;
    }

    private static String prompt() {
        System.out.println("[MENU]");
        System.out.print("MENU > ");
        return keyIn.nextLine();
    }
}
