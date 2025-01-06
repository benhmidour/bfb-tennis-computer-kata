package com.bfb.kata.tennis;

import com.bfb.kata.tennis.model.Player;
import com.bfb.kata.tennis.service.TennisScoreService;
import com.bfb.kata.tennis.service.impl.TennisScoreServiceImpl;

public class TennisGameApplication {
    public static void main(String[] args) {
        Player player1 = new Player('A');
        Player player2 = new Player('B');
        TennisScoreService scoreComputer = new TennisScoreServiceImpl(player1, player2);
        try {
            scoreComputer.computeScore("ABBBB");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}