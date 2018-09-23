package summary.java.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import summary.java.cms.annotation.Component;

public class ApplicationContext {
    HashMap<String, Object> objPool = new HashMap<>();
    public ApplicationContext(String packageName) throws Exception {
       // 패키지 이름을 파일 경로로 바꾸기.
       String path = packageName.replace(".", "/");
       
       // 패키지 상대경로를 가지고 전체 파일 경로를 알아내기.
       File file = Resources.getResourceAsFile(path);
//       System.out.println(file.getAbsolutePath());
       
       //  패키지 폴더에 들어 있는 클래스를 찾아 인스턴스를 생성, objPool에 보관.
       findClass(file, path);
   }   //  Constructor
   
   private void findClass(File path, String packagePath) throws Exception {
       File[] files = path.listFiles();
       
       for(File file : files) {
           if(file.isDirectory()) {
               findClass(file, packagePath + "/" + file.getName());
           }   else {
               String className =
                       (packagePath + "/" + file.getName())
                       .replace("/", ".")
                       .replace(".class", "");
               
               //  1) 클래스 이름을 가지고 .class파일을 찾아 메모리에 로딩함.
               Class<?> clazz = Class.forName(className);
               
               //  인터페이스인 경우 무시.
               if(clazz.isInterface()) continue;
               
               try {
                   //  2) 로딩된 클래스 정보를 가지고 인스턴스를 생성해야함..
                   //  => 해당 클래스의 생성자 정보를 얻어야함. 
                   Constructor<?> constructor = clazz.getConstructor();
                   
                   //  => 얻어온 생성자로 인스턴스 생성.
                   Object instance = constructor.newInstance();
                   
                   // => 클래스에서 component annotaion을 추출.
                   Component anno = clazz.getAnnotation(Component.class);
/*                   
                   !! 자바 컴파일러가 자동으로 .class 라는 변수를 생성함.
                   클래스 정보를 담고 있는 변수임.
                   String을 다루는 클래스 String, Integer를 다루는 클래스 Integer, etc
                   자바에서 보든 파일은 .class임
                   (interface, abstract class 뭐든 다 class로 짜여임.)
*/                   
                   // =>  Component 어노테이션의 value값이 있으면 그 값으로 objPool에 저장,
                   //   없으면 클래스 이름으로 객체를 저장.
                   
                   if(anno.value().length() > 0) {
                       //   => Component 어노테이션 value값으로 인스턴스를 objPool에 저장.
                       objPool.put(anno.value(), instance);
                   }    else {
                       objPool.put(clazz.getName(), instance);
                   }
                   
               }   catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }   //  for
   }
   public Object getBean(String name) {
       //  objPool에서 주어진 이름의 객체를 찾아 리턴시킴.
       return objPool.get(name);
   }
   
   public String[] getBeanDefinitionNames() {
       Set<String> keySet = objPool.keySet();
       String[] names = new String[keySet.size()];
       keySet.toArray(names);
       return names;
   }
}