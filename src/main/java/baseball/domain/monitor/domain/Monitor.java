package baseball.domain.monitor.domain;

public enum Monitor {

    INPUT("숫자를 입력해주세요 : "),
    CORRECT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RETRY_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String content;

    Monitor(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
