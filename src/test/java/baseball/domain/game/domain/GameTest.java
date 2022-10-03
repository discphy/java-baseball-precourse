package baseball.domain.game.domain;

import baseball.domain.computer.domain.Computer;
import baseball.domain.computer.service.ComputerService;
import baseball.domain.player.domain.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameTest {

    @Test
    void 게임_초기_세팅() {
        //given
        Player player = new Player();
        Computer computer = new ComputerService().save();

        //when
        Game game = Game.builder()
                .computer(computer)
                .player(player)
                .build();

        //then
        assertThat(game.isClear()).isFalse();
        assertNotNull(game.getPlayer());
        assertThat(game.getComputer().getAnswer().size()).isEqualTo(3);
    }

    @Test
    void 투수_볼던졌을때_값이_일치하는지() {
        //given
        Player player = new Player();
        Computer computer = new ComputerService().save();

        //when
        Game game = Game.builder()
                .computer(computer)
                .player(player)
                .build();

        game.getPlayer().setInput("123");

        //then
        assertThat(player.getInput()).isEqualTo("123");
    }
}