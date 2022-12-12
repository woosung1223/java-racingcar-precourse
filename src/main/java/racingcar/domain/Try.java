package racingcar.domain;

public class Try {
    private int count;

    private final String TRY_IS_NOT_POSITIVE = "[ERROR] 시도 횟수는 한 번 이상이어야 합니다.";

    public Try(int count) {
        validate(count);
        this.count = count;
    }

    public void addTry() {
        count--;
    }

    public boolean cantTryAnymore() {
        return count <= 0;
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
