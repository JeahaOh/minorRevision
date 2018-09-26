package summary.java.cms;
import java.util.Scanner;

import summary.java.cms.Dao.ManagerDao;
import summary.java.cms.Dao.ManagerFileDao;
import summary.java.cms.Dao.StudentDao;
import summary.java.cms.Dao.StudentFileDao;
import summary.java.cms.Dao.TeacherDao;
import summary.java.cms.Dao.TeacherFileDao;
import summary.java.cms.context.ApplicationContext;
import summary.java.cms.context.RequestMappingHandlerMapping;
import summary.java.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {
/*   
    Controller들이 App에 의존 되어 있음,  
        ApplicationContext
            -   객체 생성.
            -   의존 객체를 주입해주는 역할.(Dependency Injection)
            IoC EventController 실행을 역행, DI의 한 예.
*/
    
    public static StudentDao studentDao = new StudentFileDao();
    public static TeacherDao teacherDao = new TeacherFileDao();
    public static ManagerDao managerDao = new ManagerFileDao();
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception{
        ApplicationContext iocContainer =
                new ApplicationContext("summary.java.cms");
        
        RequestMappingHandlerMapping requestHandlerMap = 
                new RequestMappingHandlerMapping();
        
        // => IoC Contaioner에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            //  이름으로 객체를 꺼내기.
            Object obj = iocContainer.getBean(name);
            
            //  객체에서 @RequestMapping이 붙은 메소드를 찾아 저장.
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
