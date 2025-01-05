package org.example.printer.impl;

import org.example.printer.TennisPrinter;

public class ConsoleTennisPrinter implements TennisPrinter {
    @Override
    public void printPlayerWinner(char playerId) {
        System.out.println("Player " + playerId + " wins the game");
    }

    @Override
    public void printPlayer1Advantage(char player1Id, char player2Id) {
        System.out.println("Player " + player1Id + ": Advantage / Player " + player2Id + ": 40");
    }

    @Override
    public void printPlayer2Advantage(char player1Id, char player2Id) {
        System.out.println("Player " + player1Id + ": 40 / Player " + player2Id + ": Advantage");
    }

    @Override
    public void printDeuce() {
        System.out.println("Deuce");
    }

    @Override
    public void printCurrentScore(char player1Id, String player1Score, char player2Id, String player2Score) {
        System.out.println("Player " + player1Id + ": " + player1Score + " / Player " + player2Id + ": " + player2Score);
    }
}
