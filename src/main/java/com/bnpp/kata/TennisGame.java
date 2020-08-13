package com.bnpp.kata;

import com.bnpp.kata.exception.TennisException;

public class TennisGame
{
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;

    private final String playerOneName;
    private final String playerTwoName;
    private int playerOneScore = ZERO;
    private int playerTwoScore = ZERO;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName=playerOneName;
        this.playerTwoName=playerTwoName;
    }

    //getters
    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public String getScore() {

        if(!validScore()) {
            throw new TennisException("Incorrect Score");
        }
        if (hasWinner()) {
            return playerWithHighestScore() + " wins";
        }

        if (hasAdvantage()) {
            return "Advantage " + playerWithHighestScore();
        }

        if(isDeuce())
            return "Deuce";

        if(playerOneScore==playerTwoScore){
            return translateScore(playerOneScore)+" All";
        }

        return translateScore(playerOneScore)+","+translateScore(playerTwoScore);
    }

    private boolean validScore() {
        if(playerOneScore<ZERO || playerTwoScore<ZERO) {
            return false;
        }
        if(playerTwoScore>=FOUR &&  playerOneScore >=FOUR && playerTwoScore-playerOneScore>ONE){
            return false;
        }
        return true;
    }

    private boolean hasWinner() {
        if(playerTwoScore >= FOUR && playerTwoScore >= playerOneScore + TWO )
            return true;
        else if(playerOneScore >= FOUR && playerOneScore >= playerTwoScore + TWO)
            return true;
        return false;
    }

    private boolean isDeuce() {
        return playerOneScore >= THREE && playerTwoScore == playerOneScore;
    }

    private boolean hasAdvantage() {
        if (playerTwoScore >= FOUR && playerTwoScore == playerOneScore + ONE)
            return true;
        if (playerOneScore >= FOUR && playerOneScore == playerTwoScore + ONE)
            return true;

        return false;
    }

    private String playerWithHighestScore() {
        if (playerOneScore > playerTwoScore) {
            return playerOneName;
        } else {
            return playerTwoName;
        }
    }

    private String translateScore(int numericScore) {
        switch (numericScore) {
            case 3:
                return "Forty";
            case 2:
                return "Thirty";
            case 1:
                return "Fifteen";
            case 0:
                return "Love";
            default:
                throw new TennisException("Incorrect score");
        }
    }

    public void playerOneScores() {
        this.playerOneScore++;
    }

    public void playerTwoScores() {
        this.playerTwoScore++;
    }
}
