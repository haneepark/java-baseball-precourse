package baseball;

import baseball.model.Model;
import nextstep.utils.Console;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void play() {
        initGame();
        playGame();
        endGame();
    }

    private void initGame() {
        model.initGame();
    }

    private void playGame() {
        do {
            playTurn();
        } while (model.isTurnContinue());
    }

    private void playTurn() {
        view.displayEnterNumberMessage();

        try {
            model.playTurn(Console.readLine());
        } catch (InvalidBaseballNumberException e) {
            view.displayInputErrorMessage();
            return;
        }

        view.displayHintMessage(model.getTurnResult());
    }

    private void endGame() {
        if (model.isWin()) {
            view.displayWinMessage();
        }

        view.displayRestartOrExitMessage();
    }
}
