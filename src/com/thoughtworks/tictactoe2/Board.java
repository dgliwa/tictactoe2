package com.thoughtworks.tictactoe2;

import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/22/14.
 */
public class Board {
    private String[] board = {" "," "," "," "," "," "," "," "," "};
    private int[] rowOne = {0,1,2};
    private int[] rowTwo = {3,4,5};
    private int[] rowThree = {6,7,8};
    private int[] columnOne = {0,3,6};
    private int[] columnTwo = {1,4,7};
    private int[] columnThree = {2,5,8};
    private int[] diagonalOne = {0,4,8};
    private int[] diagonalTwo = {2,4,6};

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

    public boolean isWin() {
        if(isWinHorizontal(rowOne) || isWinHorizontal(rowTwo) || isWinHorizontal(rowThree)){
            return true;
        }
        else if(isWinVertical(columnOne) || isWinVertical(columnTwo) || isWinVertical(columnThree)){
            return true;
        }
        else if(isWinDiagonal(diagonalOne) || isWinDiagonal(diagonalTwo)){
            return true;
        }
        return false;
    }

    private boolean isWinDiagonal(int[] diagonal) {
        if(board[diagonal[0]].equals(board[diagonal[1]]) && board[diagonal[1]].equals(board[diagonal[2]]) && !board[diagonal[0]].equals(" ")){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isWinVertical(int[] column) {
        if(board[column[0]].equals(board[column[1]]) && board[column[1]].equals(board[column[2]]) && !board[column[0]].equals(" ")){
            return true;
        }
        else{
            return false;
        }

    }

    private boolean isWinHorizontal(int[] row) {
        if(board[row[0]].equals(board[row[1]]) && board[row[1]].equals(board[row[2]]) && !board[row[0]].equals(" ")){
            return true;
        }
        else{
            return false;
        }
    }


}
