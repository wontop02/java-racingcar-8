package racingcar.util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final int MIN_CAR_NAME = 1;
    private static final int MAX_CAR_NAME = 5;
    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 50;
    private static final String CAR_SEPARATOR = ",";
    private static final String ALPHABET_AND_COMMA_ONLY_REGEX = "^[a-zA-Z,]+$";
    private static final String ONLY_DIGIT_REGEX = "^[0-9]+$";

    private static final String BLANK_INPUT = "빈 문자열이 입력되었습니다.";
    private static final String NOT_ALPHABET_AND_COMMA_ONLY_REGEX = "알파벳과 쉼표(,)를 제외한 문자가 포함되어 있습니다.";
    private static final String INVALID_NAME_LENGTH =
            String.format(
                    "자동차 이름은 %d자 이상, %d자 미만이어야 합니다.",
                    MIN_CAR_NAME, MAX_CAR_NAME
            );
    private static final String NOT_ONLY_DIGIT = "숫자를 제외한 문자가 포함되어 있습니다.";
    private static final String INVALID_TRY_COUNT_RANGE =
            String.format(
                    "시도할 횟수는 %d 이상, %d 이하의 숫자여야 합니다.",
                    MIN_TRY_COUNT, MAX_TRY_COUNT
            );

    private InputValidator() {
    }

    public static void validateCarNames(String input) {
        validateNotBlank(input);
        validateAlphabetAndCommaOnly(input);
        List<String> inputs = Arrays.asList(input.split(CAR_SEPARATOR, -1));
        inputs.forEach(InputValidator::validateNameLength);
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }

    private static void validateAlphabetAndCommaOnly(String input) {
        if (!input.matches(ALPHABET_AND_COMMA_ONLY_REGEX)) {
            throw new IllegalArgumentException(NOT_ALPHABET_AND_COMMA_ONLY_REGEX);
        }
    }

    private static void validateNameLength(String input) {
        if (input.length() < MIN_CAR_NAME || input.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public static void validateTryCount(String input) {
        validateNotBlank(input);
        validateOnlyDigit(input);
        validateWithinIntRange(input);
        validateTryCountRange(Integer.parseInt(input));
    }

    private static void validateOnlyDigit(String input) {
        if (!input.matches(ONLY_DIGIT_REGEX)) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT);
        }
    }

    private static void validateWithinIntRange(String input) {
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_RANGE);
        }
    }

    private static void validateTryCountRange(int number) {
        if (number < MIN_TRY_COUNT || number > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_RANGE);
        }
    }
}
