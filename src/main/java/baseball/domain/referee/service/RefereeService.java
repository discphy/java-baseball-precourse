package baseball.domain.referee.service;

import baseball.domain.referee.domain.Hint;
import baseball.domain.game.service.GameService;
import baseball.domain.monitor.domain.Monitor;

import java.util.List;

public class RefereeService {

    public boolean result(List<Integer> input, List<Integer> answer) {
        int ball = 0, strike = 0;

        for (int index = 0; index < GameService.RANGE_SIZE; index++) {
            if (input.get(index).equals(answer.get(index))) { strike++; continue; }
            if (answer.contains(input.get(index))) ball++;
        }

        call(ball, strike);
        return strike == 3;
    }

    public void call(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            Monitor.print(Hint.NOTING.getContent());
            return;
        }

        String ballCall = ball != 0 ? ball + Hint.BALL.getContent() : "";
        String strikeCall = strike != 0 ? strike + Hint.STRIKE.getContent() : "";

        Monitor.print(ballCall + (ballCall.isEmpty() ? "" : " ") + strikeCall);
    }
}
