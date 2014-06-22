package com.thoughtworks.tictactoe2;

/**
 * Created by derekgilwa on 6/22/14.
 */
public class ComputerPlayer implements Player {
    private final Board board;
    private final String symbol;
    private final int playerNumber;

    public ComputerPlayer(Board board, String symbol, int playerNumber) {
        this.board = board;
        this.symbol = symbol;
        this.playerNumber = playerNumber;
    }

    @Override
    public int makeMove() {
        for(int i = 1; i<=9; i++){
            if(!board.isSpaceTaken(i)){
               return i;
            }
        }

     return 0;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String getNumber() {
        return Integer.toString(playerNumber);
    }
}
