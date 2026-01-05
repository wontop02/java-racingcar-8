package racingcar.controller;

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
        String input = inputView.readCarNames();
        InputValidator.validateCarNames(input);
        String tryCount = inputView.readTryCount();
        InputValidator.validateTryCount(tryCount);
    }
}
