package baseball.domain.computer.service;

import baseball.domain.computer.domain.Computer;
import baseball.domain.game.service.GameService;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {

    public Computer save() {
        List<Integer> picks = new ArrayList<>();

        while (picks.size() != GameService.RANGE_SIZE) {
            int pick = Randoms.pickNumberInRange(GameService.MIN_NUMBER, GameService.MAX_NUMBER);
            if (!picks.contains(pick)) picks.add(pick);
        }

        return Computer.of(picks);
    }
}
