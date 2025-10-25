package racingcar.validator;

import static racingcar.constant.ErrorMessage.DUPLICATED_CAR_NAME;
import static racingcar.constant.ErrorMessage.INVALID_ATTEMPT_COUNT;
import static racingcar.constant.GameRule.MAX_ATTEMPT_COUNT;
import static racingcar.constant.GameRule.MAX_CAR_COUNT;
import static racingcar.constant.GameRule.MIN_CAR_COUNT;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class InputValidator {
    private InputValidator() {}

    public static void validateCarNames(List<String> names) {
        validateDuplicateNames(names);
        validateCarCount(names);
    }

    public static void validateAttemptCount(String input) {
        validateInteger(input);
        validateWithinIntRange(input);
        validateAttemptCountRange(input);
    }

    private static void validateDuplicateNames(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME);
        }
    }

    private static void validateCarCount(List<String> names) {
        if (names.size() < MIN_CAR_COUNT || names.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_COUNT);
        }
    }

    private static void validateInteger(String input) {
        if (!input.matches("^-?\\d+$")) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }

    private static void validateWithinIntRange(String input) {
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }

    private static void validateAttemptCountRange(String input) {
        int value = Integer.parseInt(input);
        if (value < 1 || value > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }
}
