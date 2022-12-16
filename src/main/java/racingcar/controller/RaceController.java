package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceStatusDTO;
import racingcar.domain.Try;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.Collectors;

public class RaceController {
    private final InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Race race;

    private final String GAME_RESULT_MESSAGE = "실행 결과";

    public void run() {
        doInitializeTransaction();
        doRaceTransaction();
        makeRaceResult();
    }

    private void doInitializeTransaction() {
        try {
            initialize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            doInitializeTransaction();
        }
    }

    private void doRaceTransaction() {
        try {
            doRace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            doRaceTransaction();
        }
    }

    private void initialize() {
        Cars cars = new Cars(inputView.readCars().stream()
                .map(Car::new)
                .collect(Collectors.toList()));

        Try raceTry = new Try(inputView.readTry());

        race = new Race(cars, raceTry);
    }

    private void doRace() {
        System.out.println(GAME_RESULT_MESSAGE);
        do {
            RaceStatusDTO raceStatus = race.getStatus();
            outputView.printRaceStatus(raceStatus);
        } while (!race.isOver());
    }

    private void makeRaceResult() {
        outputView.printRaceResult(race.getWinner());
    }
}
