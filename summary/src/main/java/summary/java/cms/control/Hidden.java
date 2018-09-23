package summary.java.cms.control;

import java.util.Scanner;

import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;

@Component
public class Hidden {
    
    @RequestMapping("hidden")
    public void fuck(Scanner keyIn) {
        System.out.println("Ah?");
        System.out.println("Fuck You");
        System.out.println("Fuck You to Meet You");
    }
    
}