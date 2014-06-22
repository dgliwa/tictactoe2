package com.thoughtworks.tictactoe2;

import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/22/14.
 */
public class Board {
    String[] board = {" "," "," "," "," "," "," "," "," "};
    private PrintStream printStream;


    public Board(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void addSymbol(String symbol, int move) {
        board[move-1] = symbol;
    }

    public boolean isSpaceTaken(int move){
        if(!board[move-1].equals(" ")){
            return true;
        }
        else{
            return false;
        }
    }


    public boolean isBoardFull(){
        for (int i = 1; i <= 9; i++) {
            if(!isSpaceTaken(i)){
                return false;
            }
        }
        printStream.println("Game is a draw");
        return true;
    }

    @Override
    public String toString(){
        String boardString = String.format(" %s | %s | %s \n"+
                "------------\n"+
                " %s | %s | %s \n"+
                "------------\n"+
                " %s | %s | %s \n", board[0],board[1],board[2],board[3],board[4],board[5],board[6],board[7],board[8]);
        return boardString;
    }
}
