
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
        if (isDeuce())
            return getDeuceScore();
        else if (isAdvantage())
            return getAdvantageScore();
        else
            return getNormalScore();

    }

    private boolean isDeuce() {
        return playerOneScore == playerTwoScore;
    }

    private String getNormalScore() {
        String score = getNormalScoreFor(playerOneScore);
        score += "-";
        score += getNormalScoreFor(playerTwoScore);
        return score;
    }

    private String getNormalScoreFor(int playerScore) {
        switch (playerScore) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
        }
        return "";
    }

    private String getAdvantageScore() {

        if (isAdvantagePlayerOne())
            return "Advantage player1";
        else if (isAdvantagePlayerTwo())
            return "Advantage player2";
        else if (playerOneIsWinner())
            return "Win for player1";
        else
            return "Win for player2";
    }

    private boolean playerOneIsWinner() {
        return playerOneScore - playerTwoScore >= 2;
    }

    private boolean isAdvantagePlayerTwo() {
        return playerOneScore - playerTwoScore == -1;
    }

    private boolean isAdvantagePlayerOne() {
        return playerOneScore - playerTwoScore == 1;
    }

    private boolean isAdvantage() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private String getDeuceScore() {
        String score;
        switch (playerOneScore) {
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
