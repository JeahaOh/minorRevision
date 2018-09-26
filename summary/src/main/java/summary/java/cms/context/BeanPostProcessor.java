package summary.java.cms.context;

import summary.java.cms.context.ApplicationContext;

/*  이 규칙은 
    IoC 컨테이너(ApplicationContext)가 객체들을 생성한 후에
    마무리 작업을 수행하는 객체에 대해 호출하는 규칙임.
    따라서 마무리 작업을 수행하는 클래스를 만들 때
    반드시 다음 규칙을 준수해야 함.
*/
public interface BeanPostProcessor {
    void postProcess(ApplicationContext beanContainer);
}