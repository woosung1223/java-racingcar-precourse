package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final Cars cars;
    private final Try raceTry;

    public Race(Cars cars, Try raceTry) {
        this.cars = cars;
        this.raceTry = raceTry;
    }

    public RaceStatusDTO getStatus() {
        cars.move();
        raceTry.addTry();
        return new RaceStatusDTO(cars.getCars());
    }

    public RaceStatusDTO getWinner() {
        return new RaceStatusDTO(cars.getLeadingCar());
    }

    public boolean isOver() {
        return raceTry.cantTryAnymore();
    }
}
