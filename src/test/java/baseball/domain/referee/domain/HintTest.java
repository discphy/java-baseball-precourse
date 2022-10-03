package baseball.domain.referee.domain;

import baseball.domain.computer.domain.Computer;
import baseball.domain.player.domain.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HintTest {

    @Test
    void 힌트_낫싱() {
        //given
        Computer computer = Computer.of(Arrays.asList(1, 2, 3));
        Player player = new Player();
        String input = "789";
        int ball = 0, strike = 0;

        //when
        player.setInput(input);
        List<Integer> list = player.getInputList();
        List<Integer> answers = computer.getAnswer();

        for (int a = 0; a < 3; a++) {
            if (list.get(a).equals(answers.get(a))) { strike++; continue; }
            if (answers.contains(list.get(a))) ball++;
        }

        assertThat(strike).isEqualTo(0);
        assertThat(ball).isEqualTo(0);
    }

    @Test
    void 힌트_스트라이크_볼() {
        //given
        Computer computer = Computer.of(Arrays.asList(7, 2, 8));
        Player player = new Player();
        String input = "789";
        int ball = 0, strike = 0;

        //when
        player.setInput(input);
        List<Integer> list = player.getInputList();
        List<Integer> answers = computer.getAnswer();

        for (int a = 0; a < 3; a++) {
            if (list.get(a).equals(answers.get(a))) { strike++; continue; }
            if (answers.contains(list.get(a))) ball++;
        }

        assertThat(strike).isEqualTo(1);
        assertThat(ball).isEqualTo(1);
    }
}