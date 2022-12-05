package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RaceStatusDTO;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final String RACE_DELIMITER = " : ";
    private final String RESULT_DELIMITER = ", ";
    private final String LOCATION_EXPRESSION = "-";

    public void printRaceStatus(RaceStatusDTO raceStatus) {
        List<Car> cars = raceStatus.getCars();
        cars.forEach(car -> {
            System.out.println(car + RACE_DELIMITER + makeFormattedLocation(car.getLocation()));
        });
        addNewLine();
    }

    public void printRaceResult(RaceStatusDTO raceStatus) {
        System.out.print("최종 우승자 : ");
        List<Car> cars = raceStatus.getCars();
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
