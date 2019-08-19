
public class TennisGame1 implements TennisGame {

    public static final String PLAYER_1 = "player1";
    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String DEUCE = "Deuce";
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
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
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
