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
        Player player1 = new Player(reader, "x");
        Player player2 = new Player(reader,"o");
        Board board = new Board(System.out);
        Game game = new Game(System.out, player1, player2, board);
        Main main = new Main(game);
        main.start();
    }

    public void start() throws IOException {
        game.printBoard();

        while(!game.isDraw()){
            game.makePlayerMove();
            game.switchCurrentPlayer();
            game.printBoard();
        }
    }

}
