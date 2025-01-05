package org.example.state.impl;

import org.example.service.TennisScoreService;
import org.example.state.GameStateHandler;

public class NormalState implements GameStateHandler {
    private final TennisScoreService context;

    public NormalState(TennisScoreService context) {
        this.context = context;
    }

    @Override
    public void handlePointWonByPlayer1() {
        context.incrementPlayer1Points();
        if (context.isDeuce()) {
            context.setState(new DeuceState(context));
        } else if (context.isGameWonByPlayer1()) {
            System.out.println("Player A wins the game");
            context.resetGame();
        } else {
            context.printCurrentScore();
        }
    }

    @Override
    public void handlePointWonByPlayer2() {
        context.incrementPlayer2Points();
        if (context.isDeuce()) {
            context.setState(new DeuceState(context));
        } else if (context.isGameWonByPlayer2()) {
            System.out.println("Player B wins the game");
            context.resetGame();
        } else {
            context.printCurrentScore();
        }
    }
}