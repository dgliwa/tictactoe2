package com.thoughtworks.tictactoe2;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Created by derekgilwa on 6/21/14.
 */
public class TestMain {

    @Test
    public void shouldMainCallPrintBoardThenPromptPlayerOnStart() throws IOException {

        Game game = mock(Game.class);
        Main main = new Main(game);
        when(game.isOver()).thenReturn(true);
        main.start();

        verify(game,atLeastOnce()).printBoard();
        verify(game).makePlayerMove();
    }




}
