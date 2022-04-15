package com.company;

import java.util.Scanner;

public class Game {
    // Properties/Fields or members
    private String name;
    private String choice;
    private int score;
    private boolean winner;
    private String[] computerChoices = { "Rock", "Paper", "Scissors" };


    private Scanner scanner = new Scanner(System.in);

    public void play() {
        logGameDetails();

        // Computer instance/name
        Game computer = new Game();
        computer.setName("Computer");

        // Player instance/name
        System.out.println("Please enter your name?");
        Game player = new Game();
        String playerName = capitalize(scanner.nextLine());
        player.setName(playerName);

        while(winner == false) {
            String computerChoice = getRandomChoice();
            computer.setChoice(computerChoice);

            System.out.println("Please select a choice:");
            System.out.println();
            logChoices();

            String playerChoice = capitalize(scanner.nextLine());
            // rock
            // r => R + ock
            player.setChoice(playerChoice);
            determineWinner(player, computer);
        }
        scanner.close();
    }

    private void determineWinner(Game player, Game computer) {
        System.out.println();
        System.out.println("You choose " + player.choice);
        System.out.println("Computer choose " + computer.choice);
        System.out.println();

         if(computer.choice.equals(player.choice)) {
            System.out.println("It's a Tie!");
        }

         else if(computer.choice.equals("Rock") && player.choice.equals("Scissors") ||
                computer.choice.equals("Scissors") && player.choice.equals("Paper") ||
                computer.choice.equals("Paper") && player.choice.equals("Rock")) {

            computer.score++;
            System.out.println(computer.name + "'s score: " + computer.score);
        } else {
            player.score++;
            System.out.println(player.name + "'s score: " + player.score);
        }
        if(computer.score >= 3) {
            System.out.println(computer.name + " is the winner");
            winner = true;
        }

        if(player.score >= 3) {
            System.out.println(player.name + " is the winner");
            winner = true;
        }
    }

    private String getRandomChoice() {
        int randomNumber = (int) Math.floor(Math.random() * 3);
        return computerChoices[randomNumber];
    }

    private void logGameDetails() {
        System.out.println("Welcome to the Rock Paper Scissors Game!");
        System.out.println();
    }

    private void logChoices() {
        for (String choice : computerChoices) {
            System.out.println("1. " + choice);
        }
    }

    private boolean validateInput(String input) {
        return (input.equals("Rock") || input.equals("Paper") || input.equals("Scissors"));
    }

    public void setName(String name) {
        try {
            if(name.length() <= 3)
                throw new IllegalArgumentException();
            else this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println("Please make a correct choice!");
            e.getStackTrace();
        }

    }

    public void setChoice(String playerChoice) {
        try {
            if(validateInput(playerChoice))
                this.choice = playerChoice;
            else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Please make a correct choice!");
            e.getStackTrace();
        }

    }

    private String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

}
