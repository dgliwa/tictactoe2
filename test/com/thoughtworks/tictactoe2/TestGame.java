package com.thoughtworks.tictactoe2;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

/**
 * Created by derekgilwa on 6/21/14.
 */
public class TestGame {

    PrintStream printStream;
    Game game;
    Player player1;
    Player player2;
    Board board;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        board = mock(Board.class);
        game = new Game(printStream, player1, player2, board);

    }

    @Test
    public void shouldNewGameDrawEmptyBoard(){
        board = new Board(printStream);
        game = new Game(printStream,player1,player2,board);
        game.printBoard();
        verify(printStream).print("   |   |   \n" +
                "------------\n" +
                "   |   |   \n" +
                "------------\n" +
                "   |   |   \n");
    }

    @Test
    public void shouldSwitchPlayers(){
        game.switchCurrentPlayer();

        assertThat(player2, is(game.getCurrentPlayer()));

    }

    @Test
    public void shouldDisplayDrawMessageOnDraw(){
        game = new Game(printStream,player1, player2, board);
        when(player1.getNumber()).thenReturn("1");
        when(player2.getNumber()).thenReturn("1");
        when(board.isBoardFull()).thenReturn(true);
        game.isOver();
        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldDisplayWinMessageOnWin(){
        game = new Game(printStream,player1, player2, board);
        when(player1.getNumber()).thenReturn("1");
        when(player2.getNumber()).thenReturn("1");
        when(board.isWin()).thenReturn(true);
        game.isOver();
        verify(printStream).println("Player 1 wins!");
    }

}
