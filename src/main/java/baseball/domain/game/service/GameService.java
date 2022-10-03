package baseball.domain.game.service;

import baseball.domain.computer.service.ComputerService;
import baseball.domain.game.domain.Game;
import baseball.domain.monitor.domain.Monitor;
import baseball.domain.player.domain.Player;
import baseball.domain.player.service.PlayerService;
import baseball.domain.referee.service.RefereeService;

public class GameService {

    public static final int MIN_NUMBER = 1, MAX_NUMBER = 9, RANGE_SIZE = 3;

    private final PlayerService playerService;
    private final ComputerService computerService;
    private final RefereeService refereeService;

    private Game game;

    public GameService() {
        this.playerService = new PlayerService();
        this.computerService = new ComputerService();
        this.refereeService = new RefereeService();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void playBall() {
        readyGame();

        do {
            pitching();
            referee();
        } while (!strikeOut());

        if (reGame()) playBall();
    }

    public void readyGame() {
        game = Game.builder()
                .computer(computerService.save())
                .player(new Player())
                .build();
    }

    public void pitching() {
        Monitor.INPUT.print();
        playerService.gameInput(game.getPlayer());
    }

    public void referee() {
        boolean result = refereeService.result(game.getPlayer().getInputList(), game.getComputer().getAnswer());

        if (result) Monitor.CORRECT.print();
        game.setClear(result);
    }

    public boolean strikeOut() {
        return game.isClear();
    }

    public boolean reGame() {
        Monitor.RETRY_END.print();
        playerService.choiceInput(game.getPlayer());
        return game.getPlayer().getInput().equals("1");
    }
}
