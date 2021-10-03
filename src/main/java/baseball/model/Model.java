package baseball.model;

import java.util.ArrayList;
import java.util.List;

import baseball.InvalidBaseballNumberException;

public class Model {
    StrikeNumber number;
    TurnResult turnResult;
    boolean isWin;
    boolean isInvalidInput;

    public void initGame() {
        number = new StrikeNumber();
        turnResult = null;
        isWin = false;
        isInvalidInput = false;
    }

    public void playTurn(String userInput) throws InvalidBaseballNumberException {
        if (!validateUserInput(userInput)) {
            isInvalidInput = true;
            throw new InvalidBaseballNumberException();
        }

        turnResult = checkTurnResult(userInput);
        isWin = turnResult.isWin();
    }

    private boolean validateUserInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            return false;
        }

        return !userInput.contains("0") && userInput.length() == 3;
    }

    private TurnResult checkTurnResult(String userInput) {
        List<NumberResult> numberResults = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            numberResults.add(checkNumberResult(userInput, i));
        }

        return new TurnResult(numberResults);
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
        return !isWin && !isInvalidInput;
    }

    public boolean isWin() {
        return isWin;
    }
}
