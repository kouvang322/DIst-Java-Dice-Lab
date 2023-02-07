package edu.wctc.dice;

import org.springframework.stereotype.Component;

import java.util.Random;

//@Component
public class SixSidedDie implements DieRoller{

    public SixSidedDie(){
        System.out.println("Six sided die created");
    }

    @Override
    public int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
