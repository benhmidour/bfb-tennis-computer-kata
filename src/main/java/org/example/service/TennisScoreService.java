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
    public void player1Winner();
    public void player2Winner();
    public void player1Advantage();
    public void player2Advantage();
    public void deuce();
}
