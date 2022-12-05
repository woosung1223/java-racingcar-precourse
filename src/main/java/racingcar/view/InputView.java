package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String READ_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분";
    private final String READ_TRY_MESSAGE = "시도할 횟수는 몇회인가요?";

    private final String DELIMITER = ",";

    public List<String> readCars() {
        System.out.println(READ_CAR_MESSAGE);

        String line = Console.readLine();
        // TODO: 검증 기능 추가
        return Arrays.asList(line.split(DELIMITER));
    }

    public int readTry() {
        System.out.println(READ_TRY_MESSAGE);

        String line = Console.readLine();
        // TODO: 검증 기능 추가
        return Integer.parseInt(line);
    }
}