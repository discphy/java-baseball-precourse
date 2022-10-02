package baseball.domain.computer.domain;

import java.util.List;

public class Computer {

    private final List<Integer> answer;

    public List<Integer> getAnswer() {
        return answer;
    }

    public Computer(List<Integer> answer) {
        this.answer = answer;
    }

    public static Computer of(List<Integer> answer) {
        return new Computer(answer);
    }
}
