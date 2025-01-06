package com.bfb.kata.tennis.service.impl;

import com.bfb.kata.tennis.model.Player;
import com.bfb.kata.tennis.printer.TennisPrinter;
import com.bfb.kata.tennis.printer.impl.ConsoleTennisPrinter;
import com.bfb.kata.tennis.service.TennisScoreService;
import com.bfb.kata.tennis.state.GameStateHandler;
import com.bfb.kata.tennis.state.impl.NormalState;

public class TennisScoreServiceImpl implements TennisScoreService {

    private final Player player1;
    private final Player player2;
    private GameStateHandler state;
    private TennisPrinter printer;

    public TennisScoreServiceImpl(Player player1, Player player2) {
        this(player1, player2, new ConsoleTennisPrinter());
    }

    public TennisScoreServiceImpl(Player player1, Player player2, TennisPrinter tennisPrinter) {
        // Objects.requireNonNull | Optionnal
        if(player1 == null || player2 == null || tennisPrinter == null) throw new IllegalArgumentException("arguments could not be null");
        this.player1 = player1;
        this.player2 = player2;
        this.state = new NormalState(this);
        this.printer = tennisPrinter;
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

    public String player1Score() {
        return player1.getScore();
    }

    public String player2Score() {
        return player2.getScore();
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
        printer.printPlayerWinner(player1.getId());
    }

    public void player2Winner() {
        printer.printPlayerWinner(player2.getId());
    }
    public void player1Advantage() {
        printer.printPlayer1Advantage(player1.getId(), player2.getId());
    }

    public void player2Advantage() {
        printer.printPlayer2Advantage(player1.getId(), player2.getId());

    }

    public void deuce() {
        printer.printDeuce();
    }

    public void printCurrentScore() {
        printer.printCurrentScore(player1.getId(), player1.getScore(), player2.getId(), player2.getScore());
    }
}