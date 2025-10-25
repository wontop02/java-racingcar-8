package racingcar.validator;

import static racingcar.constant.ErrorMessage.INVALID_ATTEMPT_COUNT;
import static racingcar.constant.GameRule.MAX_ATTEMPT_COUNT;

import java.math.BigInteger;

public class AttemptCountValidator {
    private AttemptCountValidator() {}

    public static void validate(String input) {
        validateInteger(input);
        validateWithinIntRange(input);
        validateAttemptCountRange(input);
    }

    static void validateInteger(String input) {
        if (!input.matches("^-?\\d+$")) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }

    static void validateWithinIntRange(String input) {
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }

    static void validateAttemptCountRange(String input) {
        int value = Integer.parseInt(input);
        if (value < 1 || value > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }
}
