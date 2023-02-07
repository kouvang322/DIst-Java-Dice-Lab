package edu.wctc.dice;

import org.springframework.stereotype.Component;

import java.util.Scanner;

//@Component
public class ConsoleInput implements GameInput {
    public Scanner scanner = new Scanner(System.in);

    public ConsoleInput() {
        System.out.println("ConsoleInput created");
    }

    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
