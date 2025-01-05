package org.example.state.impl;

import org.example.service.TennisScoreService;
import org.example.state.GameStateHandler;

public class DeuceState implements GameStateHandler {
    private final TennisScoreService context;

    public DeuceState(TennisScoreService context) {
        this.context = context;
    }

    @Override
    public void handlePointWonByPlayer1() {
        context.setState(new AdvantageState(context, true));
        System.out.println("Player A: Advantage / Player B: 40");
    }

    @Override
    public void handlePointWonByPlayer2() {
        context.setState(new AdvantageState(context, false));
        System.out.println("Player A: 40 / Player B: Advantage");
    }
}