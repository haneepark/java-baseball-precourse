package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    StrikeNumber number;
    TurnResult turnResult;
    boolean turnContinue;

    public void initGame() {
        number = new StrikeNumber();
    }

    public void playTurn(String userInput) {
        List<NumberResult> numberResults = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            numberResults.add(checkNumberResult(userInput, i));
        }

        turnResult = new TurnResult(numberResults);
        turnContinue = !turnResult.isWin();
    }

    private NumberResult checkNumberResult(String userInput, int index) {
        String numberAsString = userInput.substring(index, index + 1);
        int numberAsInteger = Integer.parseInt(numberAsString);
        return this.number.checkResult(index, numberAsInteger);
    }

    public TurnResult getTurnResult() {
        return turnResult;
    }

    public boolean isTurnContinue() {
        return turnContinue;
    }
}
