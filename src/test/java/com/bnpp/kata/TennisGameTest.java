package com.bnpp.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest
{
    public static final String firstPlayer = "Serena";
    public static final String secondPlayer = "Maria";
    TennisGame game = new TennisGame(firstPlayer, secondPlayer);

    @Test
    public void testNewGameShouldReturnPlayerNames()
    {
        assertEquals( firstPlayer,game.getPlayerOneName() );
        assertEquals( secondPlayer,game.getPlayerTwoName() );
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

        assertEquals(secondPlayer+" wins", score);
    }

    @Test
    public void testPlayersAreDeuceAfterFirstFourScoredBalls(){

        createScore(4, 4);

        String score = game.getScore();

        assertEquals("Deuce", score);
    }

    @Test
    public void testPlayerTwoHasAdvantageOverPlayerOne(){

        createScore(4, 5);

        String score = game.getScore();

        assertEquals("Advantage "+secondPlayer, score);
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
