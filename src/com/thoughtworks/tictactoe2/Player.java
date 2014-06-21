package com.thoughtworks.tictactoe2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by derekgilwa on 6/21/14.
 */
public class Player {
    private BufferedReader reader;

    public Player(BufferedReader reader) {
        this.reader = reader;
    }

    public int makeMove() throws IOException {
        String moveString = reader.readLine();
        int move = Integer.parseInt(moveString);
        return move;
    }
}
