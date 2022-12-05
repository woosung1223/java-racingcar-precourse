package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.RaceStatusDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    private final InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Race race;

    private final String GAME_RESULT_MESSAGE = "실행 결과";

    public void run() {
        initialize();
        doRace();
        makeRaceResult();
    }

    private void initialize() {
        race = new Race(inputView.readCars(), inputView.readTry());
    }

    private void doRace() {
        System.out.println(GAME_RESULT_MESSAGE);
        do {
            RaceStatusDTO oneRaceResult = race.getOneTryRaceResult();
            outputView.printOneRaceResult(oneRaceResult);
        } while (!race.isRaceOver());
    }

    private void makeRaceResult() {
        outputView.printFinalRaceResult(race.getWinner());
    }
}
