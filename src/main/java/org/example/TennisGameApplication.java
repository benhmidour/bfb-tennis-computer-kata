package org.example;

import org.example.model.Player;
import org.example.service.TennisScoreService;
import org.example.service.impl.TennisScoreServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TennisGameApplication {
    public static void main(String[] args) {
        Player player1 = new Player('A');
        Player player2 = new Player('B');
        TennisScoreService scoreComputer = new TennisScoreServiceImpl(player1, player2);
        scoreComputer.computeScore("ABABAA");
    }
}