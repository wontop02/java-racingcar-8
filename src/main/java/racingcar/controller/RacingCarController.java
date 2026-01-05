package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        List<RacingCar> cars = makeCars();
        int tryCount = readTryCount();
        moveCars(cars, tryCount);
    }

    private List<RacingCar> makeCars() {
        String names = inputView.readCarNames();
        InputValidator.validateCarNames(names);
        return racingCarService.makeCars(names);
    }

    private int readTryCount() {
        String tryCount = inputView.readTryCount();
        InputValidator.validateTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    private void moveCars(List<RacingCar> cars, int tryCount) {
        outputView.printResultStart();
        for (int i = 0; i < tryCount; i++) {
            moveOneStep(cars);
            outputView.printEnter();
        }
    }

    private void moveOneStep(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            racingCarService.moveCar(car);
            outputView.printStatus(car.getName(), car.getLocation());
        }
    }
}
