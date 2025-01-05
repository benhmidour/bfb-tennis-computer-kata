package org.example.service.impl;

import org.example.model.Player;
import org.example.service.TennisScoreService;
import org.example.state.GameStateHandler;
import org.example.state.impl.NormalState;

public class TennisScoreServiceImpl implements TennisScoreService {

    private final Player player1;
    private final Player player2;
    private GameStateHandler state;

    public TennisScoreServiceImpl(Player player1, Player player2) {
        if(player1 == null || player2 == null) throw new IllegalArgumentException("player could not be null");
        this.player1 = player1;
        this.player2 = player2;
        this.state = new NormalState(this);
    }

    public void setState(GameStateHandler state) {
        if(state == null) throw new IllegalArgumentException("state could not be null");
        this.state = state;
    }

    public void computeScore(String input) {
        for (char c : input.toCharArray()) {
            if (c == player1.getId()) {
                state.handlePointWonByPlayer1();
            } else if (c == player2.getId()) {
                state.handlePointWonByPlayer2();
            } else {
                throw new IllegalArgumentException("Only " + player1.getId() + " and " + player2.getId() + " are accepted.");
            }
        }
    }

    public void incrementPlayer1Points() {
        player1.incrementPoints();
    }

    public void incrementPlayer2Points() {
        player2.incrementPoints();
    }

    public boolean isDeuce() {
        return player1.getPoints() >= 3 && player2.getPoints() >= 3 && player1.getPoints() == player2.getPoints();
    }

    public boolean isGameWonByPlayer1() {
        return player1.getPoints() >= 4 && player1.getPoints() >= player2.getPoints() + 2;
    }

    public boolean isGameWonByPlayer2() {
        return player2.getPoints() >= 4 && player2.getPoints() >= player1.getPoints() + 2;
    }

    public void resetGame() {
        player1.resetPoints();
        player2.resetPoints();
        setState(new NormalState(this));
    }

    public void player1Winner() {
        player1.setWinner(true);
        System.out.println("Player " + player1.getId() + " wins the game");
    }

    public void player2Winner() {
        player2.setWinner(true);
        System.out.println("Player " + player2.getId() + " wins the game");
    }
    public void player1Advantage() {
        System.out.println("Player " + player1.getId() + ": Advantage / Player " + player2.getId() + ": 40");
    }

    public void player2Advantage() {
        System.out.println("Player " + player1.getId() + ": 40 / Player " + player2.getId() + ": Advantage");
    }

    public void deuce() {
        System.out.println("Deuce");
    }

    public void printCurrentScore() {
        System.out.println("Player " + player1.getId() + ": " + player1.getScore() + " / Player " + player2.getId() + ": " + player2.getScore());
    }
}