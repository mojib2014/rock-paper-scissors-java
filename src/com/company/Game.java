package com.company;

import java.util.Scanner;

public class Game {
    // Properties;
    private String name;
    private String choice;
    private int score;
    private boolean winner;
    private String[] computerChoices = { "Rock", "Paper", "Scissors" };


    private Scanner scanner = new Scanner(System.in);

    public void play() {
        logGameDetails();

        // Computer stuff
        Game computer = new Game();
        computer.setName("Computer");

        // Player stuff
        System.out.println("Please enter your name?");
        Game player = new Game();
        String playerName = scanner.nextLine();
        player.setName(playerName);

        while(winner == false) {
            String computerChoice = getRandomChoice();
            computer.setChoice(computerChoice);

            System.out.println("Please select a choice:");
            System.out.println();
            logChoices();

            String choice = scanner.nextLine();
            // rock
            // r => R + ock
            player.setChoice(choice.substring(0, 1).toUpperCase() + choice.substring(1));

            determineWinner(player, computer);
        }

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
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
    }

    private boolean validateInput(String input) {
        return (input.equals("Rock") || input.equals("Paper") || input.equals("Scissors"));
    }

    public void setName(String name) {
        if(name.length() <= 3)
            throw new IllegalArgumentException();
        else this.name = name;
    }

    public void setChoice(String player1Choice) {
        if(validateInput(player1Choice))
            this.choice = player1Choice;
        else {
            System.out.println("Please make a correct choice!");
            throw new IllegalArgumentException();
        }
    }

}
