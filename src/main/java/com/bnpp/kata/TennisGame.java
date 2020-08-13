package com.bnpp.kata;

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

        if (hasWinner()) {
            return playerWithHighestScore() + " wins";
        }

        if(isDeuce())
            return "Deuce";

        if(playerOneScore==playerTwoScore){
            return translateScore(playerOneScore)+" All";
        }

        return translateScore(playerOneScore)+","+translateScore(playerTwoScore);
    }

    private boolean hasWinner() {
        if(playerTwoScore >= FOUR && playerTwoScore >= playerOneScore + TWO )
            return true;
        else if(playerOneScore >= FOUR && playerOneScore >= playerTwoScore + TWO)
            return true;
        return false;
    }

    private boolean isDeuce() {
        return playerOneScore >= 3 && playerTwoScore == playerOneScore;
    }

    private String playerWithHighestScore() {
        if (playerOneScore > playerTwoScore) {
            return playerOneName;
        } else {
            return playerTwoName;
        }
    }

    private String translateScore(int numericScore) {
        String convertedScore="";

        if(numericScore== ZERO) {
            convertedScore = "Love";
        }
        else if(numericScore== ONE) {
            convertedScore = "Fifteen";
        }
        else if(numericScore== TWO) {
            convertedScore = "Thirty";
        }
        else if(numericScore== THREE) {
            convertedScore = "Forty";
        }

        return  convertedScore;
    }

    public void playerOneScores() {
        this.playerOneScore++;
    }

    public void playerTwoScores() {
        this.playerTwoScore++;
    }
}
