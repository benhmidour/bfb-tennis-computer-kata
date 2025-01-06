package com.bfb.kata.tennis;

import com.bfb.kata.tennis.service.impl.TennisScoreServiceImpl;
import com.bfb.kata.tennis.state.impl.AdvantageState;
import com.bfb.kata.tennis.state.impl.DeuceState;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;

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