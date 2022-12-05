package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final String RACE_DELIMITER = " : ";
    private final String RESULT_DELIMITER = ", ";
    private final String LOCATION_EXPRESSION = "-";

    public void printOneRaceResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car + RACE_DELIMITER + makeFormattedLocation(car.getLocation()));
        });
        addNewLine();
    }

    public void printFinalRaceResult(List<Car> cars) {
        System.out.print("최종 우승자 : ");

        StringJoiner stringJoiner = new StringJoiner(RESULT_DELIMITER);
        cars.forEach(car -> stringJoiner.add(car.toString()));
        System.out.println(stringJoiner);
    }

    private String makeFormattedLocation(int location) {
        StringBuilder formattedLocation = new StringBuilder();
        for (int i = 0; i < location; i++) {
            formattedLocation.append(LOCATION_EXPRESSION);
        }
        return formattedLocation.toString();
    }

    private void addNewLine() {
        System.out.println();
    }
}
