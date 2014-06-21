package com.thoughtworks.tictactoe2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by derekgilwa on 6/21/14.
 */
public class Main {

    private Game game;

    public Main(Game game) {

        this.game = game;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Player player1 = new Player(reader);
        Player player2 = new Player(reader);
        Game game = new Game(System.out, player1, player2);
        Main main = new Main(game);
        main.start();
    }

    public void start() throws IOException {
        game.printBoard();
        game.makePlayerMove("x");
    }

}
