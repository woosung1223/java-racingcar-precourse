package racingcar.domain;

public class Try {
    private int count = 0;
    private int limit;

    public Try(int limit) {
        this.limit = limit;
    }

    public void addTry() {
        count++;
    }

    public boolean cantTryAnymore() {
        return count >= limit;
    }
}
