package baseball.domain.referee.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeServiceTest {

    private final RefereeService refereeService;

    public RefereeServiceTest() {
        this.refereeService = new RefereeService();
    }

    @Test
    void 심판_힌트_일치() {
        //when
        boolean result = refereeService.result(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));

        //then
        assertThat(result).isTrue();
    }

    @Test
    void 심판_힌트_불일치() {
        //when
        boolean result = refereeService.result(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));

        //then
        assertThat(result).isFalse();
    }
}