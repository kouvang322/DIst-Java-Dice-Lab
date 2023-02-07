package edu.wctc.dice;

import org.springframework.stereotype.Component;


//@Component
public class ConsoleOutput implements GameOutput{

    public ConsoleOutput() {
        System.out.println("ConsoleOut created");
    }

    @Override
    public void output(String text) {
        System.out.println(text);

    }
}
