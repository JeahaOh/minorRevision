package summary.java.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import summary.java.cms.annotation.Autowired;
import summary.java.cms.annotation.Component;

@Component
public class AutowiredAnnotationBeanPostProcessor 
        implements BeanPostProcessor {
    //  AutowiredBean을 처리할 녀석. Bean생성 후에 동작함.
    
    ApplicationContext beanContainer;

    public void postProcess(ApplicationContext beanContainer) {
        // objPool에 보관된 객체 목록을 꺼낸다.
        Collection<Object> objList = beanContainer.objPool.values();
        
        for (Object obj : objList) {
            //  목록에서 객체를 꺼내 Autowired Annotation이 붙은 method를 찾는다.
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method m : methods) {
                //  Autowired가 없다면,
                if (!m.isAnnotationPresent(Autowired.class)) continue;
//                System.out.println(m.getName());
                //  setter 메소드를 호출하기 위해 parameter값을 준비한다.
//            Class<?>[] pramTypes = m.getParameterTypes();
                
                //  getParameterTypes()
                //  -> parameter값 한개만 추출.
                
                
                
                
                // setter 메서드의 파라미터 타입을 알아낸다.
                Class<?> paramType = m.getParameterTypes()[0];
                
                // 그 파라미터 타입과 일치하는 객체가 objPool에서 꺼낸다.
                Object dependency = beanContainer.getBean(paramType);
                
                if (dependency == null) continue;
                
                try {
                    m.invoke(obj, dependency);
                    System.out.printf("Call %s() \n", m.getName());
                } catch (Exception e) {}
            }
        }
    }
    
}
