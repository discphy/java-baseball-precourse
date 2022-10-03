package baseball.domain.computer.service;

import baseball.domain.computer.domain.Computer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerServiceTest {

    private final ComputerService computerService;

    public ComputerServiceTest() { computerService = new ComputerService(); }

    @Test
    void 정답값_범위_내의_숫자로_구성() {
        //when
        Computer computer = computerService.save();

        //then
        computer.getAnswer().forEach(answer -> assertThat(answer).isBetween(1, 9));
    }

    @Test
    void 정답값_서로다른수_확인() {
        //when
        Computer computer = computerService.save();
        List<Integer> list = computer.getAnswer();

        //then
        assertThat(list.get(0)).isNotEqualTo(list.get(1)).isNotEqualTo(list.get(2));
    }

    @Test
    void 정답값_세자리수확인() {
        //given
        int size = 3;

        //when
        Computer computer = computerService.save();

        //then
        assertThat(computer.getAnswer().size()).isEqualTo(size);
    }
}