package com.bnpp.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest
{
    @Test
    public void testNewGameShouldReturnPlayerNames()
    {
        TennisGame game = new TennisGame("Serena" , "Maria");

        assertEquals( "Serena",game.getPlayerOneName() );
        assertEquals( "Maria",game.getPlayerTwoName() );
    }
}
