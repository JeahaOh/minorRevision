package summary.java.cms.control;

import java.util.Scanner;

import summary.java.cms.annotation.Component;

@Component("hidden")
public class Hidden implements Controller{
    
    @Override
    public void service(Scanner keyIn) {
        System.out.println("Ah?");
        System.out.println("Fuck You");
        System.out.println("Fuck You to Meet You");
    }
    
}