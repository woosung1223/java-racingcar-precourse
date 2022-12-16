package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private final static String NAME_DUPLICATED = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private static void validate(List<Car> cars) {
        checkIsDuplicated(cars);
    }

    private static void checkIsDuplicated(List<Car> cars) {
        HashSet<Car> distinctCars = new HashSet<>(cars);
        if (distinctCars.size() != cars.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATED);
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getLeadingCar() {
        Car winner = getFastestCar(cars);
        return cars.stream()
                .filter(car -> car.getLocation() == winner.getLocation())
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private Car getFastestCar(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get();
    }
}
