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
        this.player1 = player1;
        this.player2 = player2;
        this.state = new NormalState(this);
    }

    public void setState(GameStateHandler state) {
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

    public void printCurrentScore() {
        System.out.println("Player " + player1.getId() + ": " + player1.getScore() + " / Player " + player2.getId() + ": " + player2.getScore());
    }
}