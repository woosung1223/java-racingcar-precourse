package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    public List<Car> getWinner(List<Car> participants) {
        sortByLocation(participants);

        Car winner = participants.get(participants.size() - 1);

        return participants.stream()
                .filter(car -> car.getLocation() == winner.getLocation())
                .collect(Collectors.toList());
    }

    private void sortByLocation(List<Car> participants) {
        participants.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getLocation() - o2.getLocation();
            }
        });
    }
}
