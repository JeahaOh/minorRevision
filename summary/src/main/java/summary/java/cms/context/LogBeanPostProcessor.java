package summary.java.cms.context;

import java.util.Collection;

import summary.java.cms.annotation.Component;

@Component
public class LogBeanPostProcessor implements BeanPostProcessor {
    ApplicationContext beanContainer;
    
    public void postProcess(ApplicationContext beanContainer) {
       Collection<Object> objList = beanContainer.objPool.values();
       
       System.out.println("--------------------------------");
       for (Object obj : objList) {
           System.out.println(obj.getClass().getName());
       }
       System.out.println("--------------------------------");
   }
}
