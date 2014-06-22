package com.thoughtworks.tictactoe2;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/22/14.
 */
public class TestBoard {

    PrintStream printStream;
    Player player1;
    Player player2;
    Board board;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        player1 = mock(HumanPlayer.class);
        player2 = mock(HumanPlayer.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldNewBoardDrawEmptyBoard(){
        assertThat(board.toString(), is("   |   |   \n" +
                        "------------\n" +
                        "   |   |   \n" +
                        "------------\n" +
                        "   |   |   \n"));

    }


    @Test
    public void shouldDrawXOnBoardAfterPlayerOneInput() throws IOException {
        board.addSymbol("x", 1);


        assertThat(board.toString(),is(" x |   |   \n" +
                "------------\n" +
                "   |   |   \n" +
                "------------\n" +
                "   |   |   \n"));
    }

    @Test
    public void shouldDrawOOnBoardAfterPlayerTwoInput() throws IOException {
        board.addSymbol("x",1);
        board.addSymbol("o",2);

        assertThat(board.toString(),is(" x | o |   \n"+
                "------------\n"+
                "   |   |   \n"+
                "------------\n"+
                "   |   |   \n"));
    }


    @Test
    public void shouldSayGameIsOverWhenBoardIsFull() throws IOException {
        when(player1.getSymbol()).thenReturn("x");

        board.addSymbol(player1.getSymbol(),1);
        board.addSymbol(player1.getSymbol(),2);
        board.addSymbol(player1.getSymbol(),3);
        board.addSymbol(player1.getSymbol(),4);
        board.addSymbol(player1.getSymbol(),5);
        board.addSymbol(player1.getSymbol(),6);
        board.addSymbol(player1.getSymbol(),7);
        board.addSymbol(player1.getSymbol(),8);
        board.addSymbol(player1.getSymbol(),9);

        board.isBoardFull();

        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldWinWhenThreeInARowHorizontally(){
        when(player1.getSymbol()).thenReturn("x");

        board.addSymbol(player1.getSymbol(),1);
        board.addSymbol(player1.getSymbol(),2);
        board.addSymbol(player1.getSymbol(),3);

        assertThat(board.isWin(), is(true));


    }


    @Test
    public void shouldWinWhenThreeInARowVertically(){
        when(player1.getSymbol()).thenReturn("x");

        board.addSymbol(player1.getSymbol(),1);
        board.addSymbol(player1.getSymbol(),4);
        board.addSymbol(player1.getSymbol(),7);

        assertThat(board.isWin(),is(true));
    }

    @Test
    public void shouldWinWhenThreeInARowDiagonally(){
        when(player1.getSymbol()).thenReturn("x");

        board.addSymbol(player1.getSymbol(),1);
        board.addSymbol(player1.getSymbol(),5);
        board.addSymbol(player1.getSymbol(),9);

        assertThat(board.isWin(),is(true));
    }
}
