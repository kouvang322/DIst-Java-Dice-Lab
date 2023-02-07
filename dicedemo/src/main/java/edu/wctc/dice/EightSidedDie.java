package edu.wctc.dice;

import org.springframework.stereotype.Component;

import java.util.Random;

//@Component
public class EightSidedDie implements DieRoller {

    public EightSidedDie(){
        System.out.println("Eight sided die created");
    }

    @Override
    public int rollDie(){
        Random random = new Random();
        return random.nextInt(8) + 1;
    }
}
