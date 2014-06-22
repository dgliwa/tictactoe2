package com.thoughtworks.tictactoe2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by derekgilwa on 6/21/14.
 */
public class HumanPlayer implements Player {
    private BufferedReader reader;
    private String symbol;
    private int playerNumber;

    public HumanPlayer(BufferedReader reader, String symbol, int playerNumber) {
        this.reader = reader;
        this.symbol = symbol;
        this.playerNumber = playerNumber;
    }

    public int makeMove() {
        String moveString = null;
        try {
            moveString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int move = Integer.parseInt(moveString);
        return move;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getNumber() {
        return Integer.toString(playerNumber);
    }
}
