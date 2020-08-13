package com.bnpp.kata;

public class TennisGame
{
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
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
        String score="";

        if(playerOneScore== ZERO && playerTwoScore== ZERO) {
            score= "Love All";
        }

        if(playerOneScore> ZERO || playerTwoScore> ZERO) {
            if(playerOneScore==playerTwoScore){
                score= translateScore(playerOneScore)+" All";
            }
            else{
                score= translateScore(playerOneScore)+","+translateScore(playerTwoScore);
            }
        }

        return score;
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

        return  convertedScore;
    }

    public void playerOneScores() {
        this.playerOneScore++;
    }

    public void playerTwoScores() {
        this.playerTwoScore++;
    }
}
