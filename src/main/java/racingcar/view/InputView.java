package racingcar.view;

import static racingcar.constant.ErrorMessage.INVALID_ATTEMPT_COUNT;
import static racingcar.constant.GameRule.MAX_ATTEMPT_COUNT;
import static racingcar.constant.GameRule.MAX_CAR_COUNT;
import static racingcar.constant.GameRule.MIN_CAR_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
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
        validateInteger(input);
        validateIntRange(input);
        validateAttemptCountRange(input);
        return Integer.parseInt(input);
    }

    public static void validateInteger(String input) {
        if (!input.matches("^-?\\d+$")) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }

    public static void validateIntRange(String input) {
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }

    public static void validateAttemptCountRange(String input) {
        int value = Integer.parseInt(input);
        if (value < 1 || value > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }
}