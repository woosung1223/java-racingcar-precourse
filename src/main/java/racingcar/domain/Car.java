package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    private final int MOVE_POSSIBLE_VALUE = 4;
    private final int NAME_SIZE_LIMIT = 5;
    private final String NAME_SIZE_OUT_OF_RANGE = String.format("[ERROR] 자동차 이름은 %d글자 이하여야 합니다.", NAME_SIZE_LIMIT);
    private final String NAME_IS_EMPTY = "[ERROR] 자동차 이름은 빈 값이어서는 안됩니다.";

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public void move() {
        if (RandomNumGenerator.makeRandomDigit() >= MOVE_POSSIBLE_VALUE) {
            position++;
        }
    }

    public int getLocation() {
        return position;
    }

    @Override
    public String toString() {
        return name;
    }

    private void validate(String name) {
        checkSizeInRange(name);
        checkIsNotEmpty(name);
    }

    private void checkSizeInRange(String name) {
        if (name.length() > NAME_SIZE_LIMIT) {
            throw new IllegalArgumentException(NAME_SIZE_OUT_OF_RANGE);
        }
    }

    private void checkIsNotEmpty(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException(NAME_IS_EMPTY);
        }
    }
}
