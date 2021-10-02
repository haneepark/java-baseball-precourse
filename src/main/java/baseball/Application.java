package baseball;

import baseball.model.Model;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());

        controller.play();
    }
}
