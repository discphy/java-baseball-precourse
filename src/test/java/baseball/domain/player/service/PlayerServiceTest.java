package baseball.domain.player.service;

import baseball.domain.player.domain.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerServiceTest {

    private final PlayerService playerService;

    public PlayerServiceTest() {
        playerService = new PlayerService();
    }

    @Test
    void 게임_입력값_플레이어_객체값_일치() {
        //given
        String input = "123";
        Player player = new Player();

        //when
        playerService.input(player, input, PlayerService.GAME_REGEX);

        //then
        assertThat(player.getInput()).isEqualTo(input);
    }

    @Test
    void 재게임선택_입력값_플레이어_객체값_일치() {
        //given
        String input = "2";
        Player player = new Player();

        //when
        playerService.input(player, "2", PlayerService.CHOICE_REGEX);

        //then
        assertThat(player.getInput()).isEqualTo(input);
    }

    @Test
    void 게임_입력값이_예외처리되는지() {
        //given
        String input = "1234";
        Player player = new Player();

        //then
        assertThatThrownBy(() -> {
            playerService.input(player, input, PlayerService.GAME_REGEX);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재게임선택_입력값이_예외처리되는지() {
        //given
        String input = "3";
        Player player = new Player();

        //then
        assertThatThrownBy(() -> {
            playerService.input(player, input, PlayerService.CHOICE_REGEX);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}