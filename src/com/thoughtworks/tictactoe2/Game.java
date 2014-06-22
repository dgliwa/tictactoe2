package com.thoughtworks.tictactoe2;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/21/14.
 */
public class Game {

    private PrintStream printStream;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public Game(PrintStream printStream, Player player1, Player player2, Board board) {

        this.printStream = printStream;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = board;
    }

    public void printBoard() {

        printStream.print(board.toString());
    }

    public void makePlayerMove() throws IOException {
        printStream.println("Please Enter Your Move: ");
        int move = currentPlayer.makeMove();
        while(board.isSpaceTaken(move)){
            printStream.println("Location already taken");
            move = currentPlayer.makeMove();
        }
        board.addSymbol(currentPlayer.getSymbol(), move);

    }



    public void switchCurrentPlayer(){
        if(currentPlayer==player1){
            currentPlayer = player2;
        }
        else{
            currentPlayer = player1;
        }
    }





    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isOver() {
        if(board.isWin()){
            printStream.println("Player " + currentPlayer.getNumber() + " wins!");
            return true;
        }
        else if(board.isBoardFull()){
            printStream.println("Game is a draw");
            return true;
        }
        return false;

    }
}
