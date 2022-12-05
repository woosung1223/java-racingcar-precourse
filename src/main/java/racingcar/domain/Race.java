package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars; // TODO: 일급 컬렉션 적용
    private final Try raceTry;

    public Race(List<String> cars, int raceTry) {
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.raceTry = new Try(raceTry);
    }

    public List<Car> getOneTryRaceResult() {
        cars.forEach(Car::move);
        raceTry.addTry();

        return cars;
    }

    public boolean isRaceOver() {
        return raceTry.cantTryAnymore();
    }

    public List<Car> getWinner() {
        Referee racingReferee = new Referee();
        return racingReferee.getWinner(cars);
    }
}
