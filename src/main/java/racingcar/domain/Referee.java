package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    public List<Car> getWinner(List<Car> participants) {
        Car winner = getFastestCar(participants);
        return participants.stream()
                .filter(car -> car.getLocation() == winner.getLocation())
                .collect(Collectors.toList());
    }

    private Car getFastestCar(List<Car> participants) {
        return participants.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get();
    }
}