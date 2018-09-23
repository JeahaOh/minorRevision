package summary.java.cms.control;

import java.util.Scanner;

import summary.java.cms.annotation.Component;
import summary.java.cms.annotation.RequestMapping;

@Component("hell")
public class Hell {
    
    @RequestMapping
    public void hell(Scanner keyIn) {
        System.out.println("Hell..");
    }
}