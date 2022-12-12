package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars; // TODO: 일급 컬렉션 지정
    private final Try raceTry;

    private final String NAME_DUPLICATED = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

    public Race(List<String> cars, int raceTry) {
        validate(cars);
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.raceTry = new Try(raceTry);
    }

    public RaceStatusDTO getStatus() {
        cars.forEach(Car::move);
        raceTry.addTry();
        return new RaceStatusDTO(cars);
    }

    public RaceStatusDTO getWinner() {
        Referee racingReferee = new Referee();
        return new RaceStatusDTO(racingReferee.getWinner(cars));
    }

    public boolean isOver() {
        return raceTry.cantTryAnymore();
    }

    private void validate(List<String> cars) {
        checkIsDuplicated(cars);
    }

    private void checkIsDuplicated(List<String> cars) {
        HashSet<String> distinctCars = new HashSet<>(cars);
        if (distinctCars.size() != cars.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATED);
        }
    }
}
