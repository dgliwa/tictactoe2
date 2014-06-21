package com.thoughtworks.tictactoe2;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by derekgilwa on 6/21/14.
 */
public class TestMain {

    @Test
    public void shouldMainCallPrintBoardThenPromptPlayerOnStart() throws IOException {

        Game game = mock(Game.class);
        Main main = new Main(game);

        main.start();

        verify(game).printBoard();
        verify(game,times(2)).makePlayerMove();

    }




}
