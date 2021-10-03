package baseball;

import baseball.model.Model;

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
        // TODO: 2021/10/02
        return true;
    }
}
