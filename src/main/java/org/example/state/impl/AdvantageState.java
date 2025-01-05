package org.example.state.impl;

import org.example.service.TennisScoreService;
import org.example.state.GameStateHandler;

public class AdvantageState implements GameStateHandler {
    private final TennisScoreService context;
    private final boolean isPlayerAAdvantage;

    public AdvantageState(TennisScoreService context, boolean isPlayerAAdvantage) {
        this.context = context;
        this.isPlayerAAdvantage = isPlayerAAdvantage;
    }

    @Override
    public void handlePointWonByPlayer1() {
        if (isPlayerAAdvantage) {
            System.out.println("Player A wins the game");
            context.resetGame();
        } else {
            context.setState(new DeuceState(context));
            System.out.println("Deuce");
        }
    }

    @Override
    public void handlePointWonByPlayer2() {
        if (!isPlayerAAdvantage) {
            System.out.println("Player B wins the game");
            context.resetGame();
        } else {
            context.setState(new DeuceState(context));
            System.out.println("Deuce");
        }
    }
}