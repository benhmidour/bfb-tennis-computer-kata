package com.bfb.kata.tennis.state.impl;

import com.bfb.kata.tennis.service.TennisScoreService;
import com.bfb.kata.tennis.state.GameStateHandler;

public class AdvantageState implements GameStateHandler {
    private final TennisScoreService context;
    private final boolean isPlayer1Advantage;

    public AdvantageState(TennisScoreService context, boolean isPlayer1Advantage) {
        this.context = context;
        this.isPlayer1Advantage = isPlayer1Advantage;
    }

    @Override
    public void handlePointWonByPlayer1() {
        if (isPlayer1Advantage) {
            context.player1Winner();
            context.resetGame();
        } else {
            context.setState(new DeuceState(context));
            context.deuce();
        }
    }

    @Override
    public void handlePointWonByPlayer2() {
        if (!isPlayer1Advantage) {
            context.player2Winner();
            context.resetGame();
        } else {
            context.setState(new DeuceState(context));
            context.deuce();
        }
    }
}