package summary.java.cms.control;

import java.util.Scanner;

import summary.java.cms.annotation.Component;

@Component("4")
public class Hell implements Controller{
    @Override
    public void service(Scanner keyIn) {
        System.out.println("Hell..");
    }
}