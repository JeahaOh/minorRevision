package summary.java.cms.context;

import java.lang.reflect.Method;
import java.util.HashMap;

import summary.java.cms.annotation.RequestMapping;

//  명령어를 처리할 메서드 정보를 보관.
public class RequestMappingHandlerMapping {
    HashMap<String, RequestMappingHandler> handlerMap = new HashMap<>();
    
    //  객체에 들어있는 @RequestMapping 메서드를 찾아 그 정보를 보관한다.
    public void addMapping(Object instance) {
        Class<?> clazz = instance.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if(anno == null) {
                continue;
            }
            
            handlerMap.put(anno.value(), new RequestMappingHandler(instance, m));
        }
    }
    
    //  사용자가 입력한 명령어를 처리할 메서드 정보를 찾아 리턴함.
    public RequestMappingHandler getMapping(String name) {
        return handlerMap.get(name);
    }
    
    public static class RequestMappingHandler{
        private Object instance;
        private Method method;
        
        public RequestMappingHandler()  {   }
        
        public RequestMappingHandler(Object instance, Method method) {
            this.instance = instance;
            this.method = method;
        }

        //  need only Property.
        public Object getInstance() {
            return instance;
        }
        public Method getMethod() {
            return method;
        }
    }
}
/*
    모바일에서 무지막지하게 쓰인다고.
    InnerClass static이 붙지 않은 클래스. 클래스 내에서만 씀.
    NestedClass static이 붙은놈.
*/