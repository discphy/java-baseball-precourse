package baseball.domain.player.service;

import baseball.domain.player.domain.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.Optional;

public class PlayerService {

    public static final String GAME_REGEX = "[1-9]{3}", CHOICE_REGEX = "[1|2]";

    public void choiceInput(Player player) {
        input(player, Console.readLine(), CHOICE_REGEX);
    }

    public void gameInput(Player player) {
        input(player, Console.readLine(), GAME_REGEX);
    }

    public void input(Player player, String input, String regex) {
        validateInput(input, regex);
        player.setInput(input);
    }

    private void validateInput(String input, String regex) {
        Optional.of(input).ifPresent(m -> {
            if (!m.matches(regex)) throw new IllegalArgumentException("Player invalid answer size");
        });
    }
}
