package com.thoughtworks.tictactoe2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/21/14.
 */
public class TestPlayer {

    @Test
    public void shouldGetMoveNumberOnPlayerInput() throws IOException {
        BufferedReader reader = mock(BufferedReader.class);
        Player player = new Player(reader, "x",1);
        when(reader.readLine()).thenReturn("4");
        int move = player.makeMove();
        assertThat(move, is(4));
    }
}
