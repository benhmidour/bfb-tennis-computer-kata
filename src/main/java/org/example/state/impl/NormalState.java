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
            context.deuce();
        } else if (context.isGameWonByPlayer1()) {
            context.player1Winner();
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
            context.deuce();
        } else if (context.isGameWonByPlayer2()) {
            context.player2Winner();
            context.resetGame();
        } else {
            context.printCurrentScore();
        }
    }
}