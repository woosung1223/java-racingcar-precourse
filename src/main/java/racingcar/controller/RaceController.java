package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;

import java.util.List;

public class RaceController {
    private final InputView inputView = new InputView();
//    OutputView outputView = new OutputView();
    private Race race;

    public void run() {
        initialize();
        doRace();
        makeRaceResult();
    }

    private void initialize() {
        race = new Race(inputView.readCars(), inputView.readTry());
    }

    private void doRace() {
        do {
            List<Integer> oneRaceResult = race.getOneTryRaceResult();
//            outputView.print(oneRaceResult);
        } while (!race.isRaceOver());
    }

    private void makeRaceResult() {
//        outputView.print(race.getWinner());
    }
}
