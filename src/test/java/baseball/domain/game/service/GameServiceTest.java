package baseball.domain.game.service;

import baseball.domain.computer.domain.Computer;
import baseball.domain.computer.service.ComputerService;
import baseball.domain.game.domain.Game;
import baseball.domain.player.domain.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameServiceTest {

    private final GameService gameService;

    public GameServiceTest() {
        this.gameService = new GameService();
    }

    @Test
    void 게임_초기_세팅_확인() {
        //when
        gameService.readyGame();

        //then
        assertThat(gameService.getGame().isClear()).isFalse();
        assertThat(gameService.getGame().getPlayer()).isNotNull();
        assertThat(gameService.getGame().getComputer().getAnswer().size()).isEqualTo(GameService.RANGE_SIZE);
    }

    @Test
    void 게임_스트라이크_아웃() {
        //given
        String input = "123";
        List<Integer> answer = Arrays.asList(1, 2, 3);

        Player player = new Player();
        player.setInput(input);

        gameService.setGame(Game.builder()
                        .player(player)
                        .computer(Computer.of(answer))
                        .build());

        //when
        gameService.referee();

        //then
        assertThat(gameService.strikeOut()).isTrue();
    }

    @Test
    void 게임_낫싱() {
        //given
        String input = "456";
        List<Integer> answer = Arrays.asList(1, 2, 3);

        Player player = new Player();
        player.setInput(input);

        gameService.setGame(Game.builder()
                        .player(player)
                        .computer(Computer.of(answer))
                        .build());

        //when
        gameService.referee();

        //then
        assertThat(gameService.strikeOut()).isFalse();
    }

    @Test
    void 볼_스트라이크() {
        //given
        String input = "341";
        List<Integer> answer = Arrays.asList(1, 2, 3);

        Player player = new Player();
        player.setInput(input);

        gameService.setGame(Game.builder()
                        .player(player)
                        .computer(Computer.of(answer))
                        .build());

        //when
        gameService.referee();

        //then
        assertThat(gameService.strikeOut()).isFalse();
    }
}