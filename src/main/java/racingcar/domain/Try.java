package racingcar.domain;

public class Try {
    private int count = 0;
    private int limit;

    private final String TRY_IS_NOT_POSITIVE = "[ERROR] 시도 횟수는 한 번 이상이어야 합니다.";

    public Try(int limit) {
        validate(limit);
        this.limit = limit;
    }

    public void addTry() {
        count++;
    }

    public boolean cantTryAnymore() {
        return count >= limit;
    }

    private void validate(int limit) {
        checkIsPositive(limit);
    }

    private void checkIsPositive(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException(TRY_IS_NOT_POSITIVE);
        }
    }
}
