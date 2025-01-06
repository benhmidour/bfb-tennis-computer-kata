package com.bfb.kata.tennis;

import com.bfb.kata.tennis.service.impl.TennisScoreServiceImpl;
import com.bfb.kata.tennis.state.impl.DeuceState;
import com.bfb.kata.tennis.state.impl.NormalState;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;

// tested
public class NormalStateTest {

    private NormalState normalState;

    @Mock
    private TennisScoreServiceImpl tennisScoreService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        normalState = new NormalState(tennisScoreService);
    }

    @Test
    public void testNormalStatePlayer1WinsPoint() {
        normalState.handlePointWonByPlayer1();

        verify(tennisScoreService, times(1)).incrementPlayer1Points();
        verify(tennisScoreService, never()).resetGame();
    }

    @Test
    public void testNormalStatePlayer2WinsPoint() {
        normalState.handlePointWonByPlayer2();

        verify(tennisScoreService, times(1)).incrementPlayer2Points();
        verify(tennisScoreService, never()).resetGame();
    }

    @Test
    public void testTransitionToDeuceState() {
        when(tennisScoreService.isDeuce()).thenReturn(true);

        normalState.handlePointWonByPlayer1();

        verify(tennisScoreService, times(1)).setState(any(DeuceState.class));
    }
}