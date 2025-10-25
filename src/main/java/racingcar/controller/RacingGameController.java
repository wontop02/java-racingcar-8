package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public void gameStart() {
        List<String> carNames = InputView.getCarNames();
        List<Car> cars = carNames.stream().map(Car::new).toList();
        int attemptCount = InputView.getAttemptCount();

        RacingGame racingGame = new RacingGame(cars, attemptCount);

        System.out.println("\n실행 결과");
        while (!racingGame.isFinished()) {
            playOneRound(racingGame);
        }

        List<String> winners = racingGame.decideWinners();
        OutputView.printWinners(winners);
    }

    public void playOneRound(RacingGame racingGame) {
        racingGame.moveCars();
        OutputView.printCarPosition(racingGame.getCars());
        System.out.println();
    }
}
