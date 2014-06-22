package com.thoughtworks.tictactoe2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by derekgilwa on 6/21/14.
 */
public class Player {
    private BufferedReader reader;
    private String symbol;
    private int playerNumber;

    public Player(BufferedReader reader, String symbol, int playerNumber) {
        this.reader = reader;
        this.symbol = symbol;
        this.playerNumber = playerNumber;
    }

    public int makeMove() throws IOException {
        String moveString = reader.readLine();
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
