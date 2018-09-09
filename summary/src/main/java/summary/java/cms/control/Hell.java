package summary.java.cms.control;

import java.util.Scanner;

public class Hell implements Controller{
    public String name = "4";
    @Override
    public void service(Scanner keyIn) {
        System.out.println("Hell..");
    }
}