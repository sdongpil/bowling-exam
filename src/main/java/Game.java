public class Game {
    int[] rolls = new int[21];
    int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] += pins;
    }

    public int getScore() {
        int score = 0;
        int firstRollFrame = 0;


        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(firstRollFrame)) {
                score += 10 + rolls[firstRollFrame + 2];
                firstRollFrame += 2;
            } else if (isStrike(rolls[firstRollFrame])) {
                score += 10 + rolls[firstRollFrame + 1]+ rolls[firstRollFrame + 2];
                firstRollFrame += 1;
            } else {
                score += rolls[firstRollFrame] + rolls[firstRollFrame + 1];
                firstRollFrame += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int rolls) {
        return rolls == 10;
    }

    private boolean isSpare(int firstRollFrame) {
        return isStrike(rolls[firstRollFrame] + rolls[firstRollFrame + 1]);
    }

}
