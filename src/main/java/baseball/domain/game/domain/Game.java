package baseball.domain.game.domain;

import baseball.domain.computer.domain.Computer;
import baseball.domain.player.domain.Player;

public class Game {

    private boolean clear;
    private Computer computer;
    private Player player;

    public Game(Computer computer, Player player) {
        this.clear = false;
        this.player = player;
        this.computer = computer;
    }

    public boolean isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Computer computer;
        private Player player;

        public Builder computer(Computer computer) {
            this.computer = computer;
            return this;
        }

        public Builder player(Player player) {
            this.player = player;
            return this;
        }

        public Game build() {
            return new Game(computer, player);
        }
    }
}
