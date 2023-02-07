package edu.wctc.dice;

import org.springframework.stereotype.Component;

import javax.swing.*;

//@Component
public class PopupOutput implements GameOutput{
    public PopupOutput(){
        System.out.println("PopupInput created");
    }

    @Override
    public void output(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
}
