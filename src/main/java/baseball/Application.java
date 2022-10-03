package baseball;

import baseball.domain.game.service.GameService;

public class Application {
    public static void main(String[] args) {
        new GameService().playBall();
    }
}
