package com.example;

import org.example.model.Player;
import org.example.service.impl.TennisScoreServiceImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class TennisScoreServiceImplTest {

    @Mock
    private Player player1;

    @Mock
    private Player player2;

    private TennisScoreServiceImpl tennisScoreService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tennisScoreService = new TennisScoreServiceImpl(player1, player2);
    }

    @Test
    public void testComputeScore_Player1WinsPoint() {
        when(player1.getId()).thenReturn('A');
        when(player2.getId()).thenReturn('B');

        tennisScoreService.computeScore("A");

        verify(player1).incrementPoints();
        verify(player2, never()).incrementPoints();
    }

    @Test
    public void testComputeScore_Player2WinsPoint() {
        when(player1.getId()).thenReturn('A');
        when(player2.getId()).thenReturn('B');

        tennisScoreService.computeScore("B");

        verify(player2).incrementPoints();
        verify(player1, never()).incrementPoints();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testComputeScore_InvalidInput() {
        when(player1.getId()).thenReturn('A');
        when(player2.getId()).thenReturn('B');

        tennisScoreService.computeScore("C");
    }

    @Test
    public void testIsDeuce() {
        when(player1.getPoints()).thenReturn(3);
        when(player2.getPoints()).thenReturn(3);

        boolean result = tennisScoreService.isDeuce();

        assertTrue(result);
    }

    @Test
    public void testIsGameWonByPlayer1() {
        when(player1.getPoints()).thenReturn(4);
        when(player2.getPoints()).thenReturn(2);

        boolean result = tennisScoreService.isGameWonByPlayer1();

        assertTrue(result);
    }

    @Test
    public void testIsGameWonByPlayer2() {
        when(player1.getPoints()).thenReturn(2);
        when(player2.getPoints()).thenReturn(4);

        boolean result = tennisScoreService.isGameWonByPlayer2();

        assertTrue(result);
    }

    @Test
    public void testResetGame() {
        tennisScoreService.resetGame();

        verify(player1).resetPoints();
        verify(player2).resetPoints();
    }

    @Test
    public void testPrintCurrentScore() {
        when(player1.getScore()).thenReturn("30");
        when(player2.getScore()).thenReturn("40");

        tennisScoreService.printCurrentScore();

        verify(player1).getScore();
        verify(player2).getScore();
    }
}