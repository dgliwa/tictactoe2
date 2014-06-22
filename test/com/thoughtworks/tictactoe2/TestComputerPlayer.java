package com.thoughtworks.tictactoe2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/22/14.
 */
public class TestComputerPlayer {

    @Test
    public void shouldComputerPlayerMakeMove(){
        Board board = mock(Board.class);
        Player player = new ComputerPlayer(board, "x", 1);
        when(board.isSpaceTaken(1)).thenReturn(true);
        when(board.isSpaceTaken(2)).thenReturn(false);

        int move = player.makeMove();

        assertThat(move, is(2));
    }
}
