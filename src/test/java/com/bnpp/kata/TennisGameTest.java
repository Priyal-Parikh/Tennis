package com.bnpp.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest
{
    TennisGame game = new TennisGame("Serena" , "Maria");

    @Test
    public void testNewGameShouldReturnPlayerNames()
    {
        assertEquals( "Serena",game.getPlayerOneName() );
        assertEquals( "Maria",game.getPlayerTwoName() );
    }

    @Test
    public void testNewGameShouldReturnLoveAll()
    {
        String score = game.getScore();

        assertEquals("Love All", score);
    }
}
