package com.bnpp.kata;

public class TennisGame
{
    private String playerOneName;
    private String playerTwoName;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

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
        String score="";

        if(playerOneScore==0 && playerTwoScore==0) {
            score= "Love All";
        }
        if(playerOneScore>0 || playerTwoScore>0) {
            score= translateScore(playerOneScore)+","+translateScore(playerTwoScore);
        }

        return score;
    }

    private String translateScore(int numericScore) {
        String convertedScore="";

        if(numericScore==0) {
            convertedScore = "Love";
        }
        else if(numericScore==1) {
            convertedScore = "Fifteen";
        }

        return  convertedScore;
    }

    public void playerOneScores() {
        this.playerOneScore++;
    }
}
