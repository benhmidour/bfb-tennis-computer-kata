package com.example;

import org.example.model.Player;
import org.example.service.impl.TennisScoreServiceImpl;
import org.example.state.impl.AdvantageState;
import org.example.state.impl.DeuceState;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class DeuceStateTest {

    private DeuceState deuceState;

    @Mock
    private TennisScoreServiceImpl tennisScoreService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        deuceState = new DeuceState(tennisScoreService);
    }

    @Test
    public void testDeuceStatePlayer1WinsPoint() {
        deuceState.handlePointWonByPlayer1();

        verify(tennisScoreService, times(1)).setState(any(AdvantageState.class));
    }

    @Test
    public void testDeuceStatePlayer2WinsPoint() {
        deuceState.handlePointWonByPlayer2();

        verify(tennisScoreService, times(1)).setState(any(AdvantageState.class));
    }
}