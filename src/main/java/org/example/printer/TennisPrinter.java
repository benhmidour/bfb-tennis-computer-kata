package org.example.printer;

public interface TennisPrinter {

    public void printPlayerWinner(char playerId);
    public void printPlayer1Advantage(char player1Id, char player2Id);
    public void printPlayer2Advantage(char player1Id, char player2Id);
    public void printDeuce();
    public void printCurrentScore(char player1Id, String player1Score, char player2Id, String player2Score);
}
