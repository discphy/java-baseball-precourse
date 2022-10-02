package baseball.domain.computer.service;

import baseball.domain.game.service.GameService;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerServiceTest {

    @Test
    void 범위_내의_숫자로_구성() {
        //when
        int pick = Randoms.pickNumberInRange(GameService.MIN_NUMBER, GameService.MAX_NUMBER);

        //then
        assertThat(pick).isBetween(1, 9);
    }

    @Test
    void 서로다른수_확인() {
        //given
        List<Integer> list = new ArrayList<>();

        //when
        while (list.size() != 3) {
            int pick = Randoms.pickNumberInRange(GameService.MIN_NUMBER, GameService.MAX_NUMBER);

            if (!list.contains(pick)) list.add(pick);
        }

        //then
        assertThat(list.get(0)).isNotEqualTo(list.get(1)).isNotEqualTo(list.get(2));
    }

    @Test
    void 세자리수확인() {
        //given
        List<Integer> list = new ArrayList<>();

        //when
        while (list.size() != 3) {
            int pick = Randoms.pickNumberInRange(GameService.MIN_NUMBER, GameService.MAX_NUMBER);

            if (!list.contains(pick)) list.add(pick);
        }

        //then
        assertThat(list.size()).isEqualTo(3);
    }
}