package edu.wctc.dice;

import org.springframework.stereotype.Component;

import javax.swing.*;

//@Component
public class PopupInput implements GameInput{
    public PopupInput() {
        System.out.println("PopupInput created");
    }

    @Override
    public String getInput(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
}
