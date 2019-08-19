
public class TennisGame1 implements TennisGame {

    private static final String PLAYER_1 = "player1";
    private static final String LOVE_ALL = "Love-All";
    private static final String FIFTEEN_ALL = "Fifteen-All";
    private static final String THIRTY_ALL = "Thirty-All";
    private static final String DEUCE = "Deuce";
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_1))
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore;
        if (playerOneScore == playerTwoScore)
        {
            score = getEvenScores();
        }
        else if (isAdvantage())
        {
            score = getScoreForAdvantage();
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = playerOneScore;
                else { score+="-"; tempScore = playerTwoScore;}
                score = getNormalScore(score, tempScore);
            }
        }
        return score;
    }

    private String getNormalScore(String score, int tempScore) {
        switch(tempScore)
        {
            case 0:
                score+= LOVE;
                break;
            case 1:
                score+= FIFTEEN;
                break;
            case 2:
                score+= THIRTY;
                break;
            case 3:
                score+= FORTY;
                break;
        }
        return score;
    }

    private String getScoreForAdvantage() {
        String score;
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private boolean isAdvantage() {
        return playerOneScore >=4 || playerTwoScore >=4;
    }

    private String getEvenScores() {
        String score;
        switch (playerOneScore)
        {
            case 0:
                    score = LOVE_ALL;
                break;
            case 1:
                    score = FIFTEEN_ALL;
                break;
            case 2:
                    score = THIRTY_ALL;
                break;
            default:
                    score = DEUCE;
                break;

        }
        return score;
    }
}
