package baseball.domain.player.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void 게임_입력값_정규식() {
        assertThat("123".matches("[1-9]{3}")).isTrue();
    }

    @Test
    void 재게임선택_입력값_정규식() {
        assertThat("1".matches("[1|2]")).isTrue();
    }

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
    void 재게임선택_입력값_잘못입력시() {
        //given
        String input = "3";

        //when
        boolean result = input.matches("[1|2]");

        //then
        assertThat(result).isFalse();
    }
}