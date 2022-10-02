package baseball.domain.game.domain;

public enum Hint {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTING("낫싱");

    private final String content;

    Hint(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
