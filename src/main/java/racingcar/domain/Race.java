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

    public List<Integer> getOneTryRaceResult() {
        cars.forEach(Car::move);
        raceTry.addTry();

        return cars.stream()
                .map(Car::getLocation)
                .collect(Collectors.toList());
    }

    public boolean isRaceOver() {
        return raceTry.cantTryAnymore();
    }
}
