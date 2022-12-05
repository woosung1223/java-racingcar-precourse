package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final Try raceTry;

    public Race(List<String> cars, int raceTry) {
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.raceTry = new Try(raceTry);
    }

    public RaceStatusDTO getRaceStatus() {
        cars.forEach(Car::move);
        raceTry.addTry();
        return new RaceStatusDTO(cars);
    }

    public boolean isOver() {
        return raceTry.cantTryAnymore();
    }

    public RaceStatusDTO getWinner() {
        Referee racingReferee = new Referee();
        return new RaceStatusDTO(racingReferee.getWinner(cars));
    }
}
