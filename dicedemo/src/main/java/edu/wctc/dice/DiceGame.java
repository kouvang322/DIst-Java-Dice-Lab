package edu.wctc.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DiceGame {
    @Autowired
    private GameInput in;
    @Autowired
    private GameOutput out;
    @Autowired
    private DieRoller gameDie;
    private List<Player> players = new ArrayList<>();
    private int currentRound = 1;

    public DiceGame() {
        System.out.println("DiceGame created");
    }

    public void play() {
        initPlayers();

        while(!players.isEmpty()) {
            beginRound();
            boolean evens = rollDice();
            endRound(evens);
            currentRound++;
        }

        out.output("Game Over");
    }

    private boolean rollDice() {
        int die1 = gameDie.rollDie();
        int die2 = gameDie.rollDie();

        boolean even = (die1 + die2) % 2 == 0;

        String outcome = String.format("Roll was %d, %d%n", die1, die2);

        out.output(outcome + (even ? "Players WIN!" : "Players LOSE!"));

        return even;
    }

//    private int rollDie() {
//        Random random = new Random();
//        return random.nextInt(6) + 1;
//    }

    private void endRound(boolean evens) {
        Iterator<Player> playerIterator = players.iterator();

        while(playerIterator.hasNext()) {
            Player currentPlayer = playerIterator.next();
            if (evens) {
                currentPlayer.wins();
            }else {
                currentPlayer.loses();
                if( currentPlayer.isBankrupt()) {
                    playerIterator.remove();
                }
            }
        }
        playerReport();
    }

    private void playerReport() {
        String report = String.format("Player Report (Round%d) %n", currentRound);
        if(players.isEmpty()){
            report += " No players remain!\n";
        } else {
            for(Player player : players) {
                report += String.format(" %s%n", player.toString());
            }
        }
        out.output(report);
    }

    private void initPlayers() {
        String playerName = in.getInput("Enter player name: ");
        while(players.isEmpty() || !playerName.equalsIgnoreCase("Q")){
            players.add(new Player(playerName));
            playerName = in.getInput("Enter player name (Q to quit): ");
        }
    }

    private void beginRound() {
        Iterator<Player> playerIterator = players.iterator();
        while(playerIterator.hasNext()) {
            Player currentPlayer = playerIterator.next();
            String choice = getPlayerChoice(currentPlayer.getName());
            if( choice.equals("2")) {
                playerIterator.remove();
            } else {
                int bet = getBet(currentPlayer.getCash());
                currentPlayer.setBet(bet);
            }
        }
    }

    private String getPlayerChoice(String playerName) {
        String menu = playerName.toUpperCase() + "'s turn:\n"
                + " 1. Place Bet\n"
                + " 2. Cash Out (Quit)";
        return in.getInput(menu);
    }

    private int getBet(int cash) {
        String bet = in.getInput(String.format("Bet how much? ($%d available): ", cash));
        return Integer.parseInt(bet);
    }
}
