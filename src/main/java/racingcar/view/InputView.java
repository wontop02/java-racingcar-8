package racingcar.view;

import static racingcar.constant.ErrorMessage.INVALID_ATTEMPT_COUNT_FORMAT;
import static racingcar.constant.GameRule.MAX_CAR_COUNT;
import static racingcar.constant.GameRule.MIN_CAR_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class InputView {
    public static String requestInput() {
        return Console.readLine();
    }

    public static List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        if (carNames.size() < MIN_CAR_COUNT || carNames.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_COUNT);
        }
        return carNames;
    }

    public static int parseAttemptCount(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_FORMAT);
        }
        return Integer.parseInt(input);
    }
}