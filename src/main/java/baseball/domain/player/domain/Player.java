package baseball.domain.player.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<Integer> getInputList() {
        List<Integer> list = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            list.add(Integer.valueOf(Character.toString(ch)));
        }

        return list;
    }
}
