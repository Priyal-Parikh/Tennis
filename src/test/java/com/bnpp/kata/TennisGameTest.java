package com.bnpp.kata;

import com.bnpp.kata.exception.TennisException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TennisGameTest
{
    public static final String firstPlayer = "Serena";
    public static final String secondPlayer = "Maria";
    TennisGame game = new TennisGame(firstPlayer, secondPlayer);

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

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

    @Test
    public void testShouldRaiseExceptionIfScoreIsNotCorrect(){

        createScore(5, 8);

        exceptionRule.expect(TennisException.class);
        exceptionRule.expectMessage("Incorrect Score");

        String score = game.getScore();
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
