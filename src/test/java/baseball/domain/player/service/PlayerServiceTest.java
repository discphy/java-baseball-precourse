package baseball.domain.player.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class PlayerServiceTest {
    @Test
    void 게임_입력값_잘못입력시() {
        //given
        String input = "우테코";

        //when
        boolean result = input.matches("[1-9]{3}");

        //then
        assertThat(result).isFalse();
    }

    @Test
    void 게임종료후_재시작_입력값_잘못입력시() {
        //given
        String input = "3";

        //when
        boolean result = input.matches("[1|2]");

        //then
        assertThat(result).isFalse();
    }
}