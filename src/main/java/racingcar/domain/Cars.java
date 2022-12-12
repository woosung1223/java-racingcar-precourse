package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
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
