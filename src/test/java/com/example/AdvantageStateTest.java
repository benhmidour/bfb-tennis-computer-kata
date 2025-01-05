package com.example;

import org.example.model.Player;
import org.example.service.impl.TennisScoreServiceImpl;
import org.example.state.impl.AdvantageState;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class AdvantageStateTest {

    private AdvantageState advantageState;
    @Mock
    private TennisScoreServiceImpl tennisScoreService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        advantageState = new AdvantageState(tennisScoreService, true);
    }

    @Test
    public void testAdvantageStatePlayerAWins() {
        advantageState.handlePointWonByPlayer1();

        verify(tennisScoreService, times(1)).resetGame();
    }

    @Test
    public void testAdvantageStatePlayerBWins() {
        advantageState = new AdvantageState(tennisScoreService, false); // Player B has Advantage

        advantageState.handlePointWonByPlayer2();

        verify(tennisScoreService, times(1)).resetGame();
    }
}