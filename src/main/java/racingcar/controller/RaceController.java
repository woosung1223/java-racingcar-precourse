package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.RaceStatusDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        race = Race.of(inputView.readCars(), inputView.readTry());
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
