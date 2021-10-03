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
        model.playTurn(Console.readLine());
        view.displayHintMessage(model.getTurnResult());
    }

    private void endGame() {
        view.displayWinMessage();
    }
}
