package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RaceStatusDTO {
    private final List<Car> cars;

    public RaceStatusDTO(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
