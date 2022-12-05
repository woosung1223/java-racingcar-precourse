package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Try;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String READ_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분";
    private final String READ_TRY_MESSAGE = "시도할 횟수는 몇회인가요?";

    private final String DELIMITER = ",";

    public List<String> readCars() {
        System.out.println(READ_CAR_MESSAGE);

        String line = Console.readLine();
        validateCar(line);
        return Arrays.asList(line.split(DELIMITER));
    }

    public int readTry() {
        System.out.println(READ_TRY_MESSAGE);

        String line = Console.readLine();
        validateTry(line);
        return Integer.parseInt(line);
    }

    private void validateCar(String line) {
        try {
            Arrays.stream(line.split(DELIMITER))
                    .map(Car::new);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateTry(String line) {
        try {
            new Try(Integer.parseInt(line));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}