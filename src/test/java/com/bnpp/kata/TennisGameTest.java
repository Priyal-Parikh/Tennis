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

    @Test
    public void testPlayerOneScoresFirstBall()
    {
        game.playerOneScores();

        String score = game.getScore();

        assertEquals("Fifteen,Love", score);
    }

    @Test
    public void testPlayerTwoScoresFirstBall()
    {
        game.playerTwoScores();

        String score = game.getScore();

        assertEquals("Love,Fifteen", score);
    }

    @Test
    public void testBothPlayerScoresFirstBall(){

        game.playerOneScores();
        game.playerTwoScores();

        String score = game.getScore();

        assertEquals("Fifteen All", score);
    }

    @Test
    public void testPlayerOneScoresFirstTwoBalls(){
        createScore(2,0);

        String score = game.getScore();

        assertEquals("Thirty,Love", score);
    }

    @Test
    public void testPlayerOneScoresFirstThreeBalls(){

        createScore(3, 0);

        String score = game.getScore();

        assertEquals("Forty,Love", score);
    }

    @Test
    public void testPlayerTwoScoresAllFourBallsToWinGame(){

        createScore(0, 4);

        String score = game.getScore();

        assertEquals("Maria wins", score);
    }

    @Test
    public void testPlayersAreDeuceAfterFirstFourScoredBalls(){

        createScore(4, 4);

        String score = game.getScore();

        assertEquals("Deuce", score);
    }

    private void createScore(int playerOneBalls, int playerTwoBalls) {
        for(int i=0; i<playerOneBalls; i++) {
            game.playerOneScores();
        }
        for(int i=0; i<playerTwoBalls; i++) {
            game.playerTwoScores();
        }
    }
}
