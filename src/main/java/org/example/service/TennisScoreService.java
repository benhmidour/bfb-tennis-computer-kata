package org.example.service;

import org.example.state.GameStateHandler;

public interface TennisScoreService {
    public void computeScore(String input);

    public void setState(GameStateHandler state);
    public void incrementPlayer1Points();
    public void incrementPlayer2Points();
    public boolean isDeuce();
    public boolean isGameWonByPlayer1();
    public boolean isGameWonByPlayer2();
    public void resetGame();
    public void printCurrentScore();
}
