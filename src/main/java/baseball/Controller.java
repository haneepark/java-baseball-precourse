package baseball;

import baseball.model.Model;
import baseball.model.TurnResult;
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
    }

    private void initGame() {
        model.initGame();
    }

    private void playGame() {
        boolean isWin;

        do {
            isWin = playTurnAndGetResult();
        } while (!isWin);
    }

    private boolean playTurnAndGetResult() {
        view.displayEnterNumberMessage();
        String userInput = Console.readLine();
        TurnResult turnResult = model.checkTurnResult(userInput);
        return turnResult.isWin();
    }
}
