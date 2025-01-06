package com.example;

import org.example.model.Player;
import org.example.printer.TennisPrinter;
import org.example.service.impl.TennisScoreServiceImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class TennisScoreServiceImplTest {

    @Mock
    private TennisPrinter tennisPrinter;

    private TennisScoreServiceImpl tennisScoreService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Player player1 = new Player('A');
        Player player2 = new Player('B');
        tennisScoreService = new TennisScoreServiceImpl(player1, player2, tennisPrinter);
    }

    @Test
    public void testComputeScore_Player1WinsPoint() {
        tennisScoreService.computeScore("A");

        Assert.assertEquals(tennisScoreService.player1Score(), "15");
    }

    @Test
    public void testComputeScore_Player2WinsPoint() {
        tennisScoreService.computeScore("B");

        Assert.assertEquals(tennisScoreService.player2Score(), "15");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testComputeScore_InvalidInput() {
        tennisScoreService.computeScore("C");
    }

    @Test
    public void testIsDeuce() {
        tennisScoreService.computeScore("AAABBB");
        boolean result = tennisScoreService.isDeuce();

        assertTrue(result);
        verify(tennisPrinter, times(5)).printCurrentScore(anyChar(), any(), anyChar(), any());
        verify(tennisPrinter, times(1)).printDeuce();
    }

    @Test
    public void testComputeScore_Player1Advantage() {
        tennisScoreService.computeScore("ABABABA");

        verify(tennisPrinter, times(1)).printPlayer1Advantage('A', 'B');
    }

    @Test
    public void testIsGameWonByPlayer1() {
        tennisScoreService.computeScore("AAAA");

        verify(tennisPrinter, times(1)).printPlayerWinner('A');
        verify(tennisPrinter, times(3)).printCurrentScore(anyChar(), any(), anyChar(), any());
    }

    @Test
    public void testIsGameWonByPlayer2() {
        tennisScoreService.computeScore("BBBB");

        verify(tennisPrinter, times(1)).printPlayerWinner('B');
        verify(tennisPrinter, times(3)).printCurrentScore(anyChar(), any(), anyChar(), any());
    }

    @Test
    public void testResetGame() {
        tennisScoreService.computeScore("AAAA");
        assertEquals(tennisScoreService.player1Score(), "0");
        assertEquals(tennisScoreService.player2Score(), "0");
    }

    @Test
    public void testPrintCurrentScore() {
        tennisScoreService.computeScore("A");

        verify(tennisPrinter, times(1)).printCurrentScore(anyChar(),any(),anyChar(),any());
    }
}