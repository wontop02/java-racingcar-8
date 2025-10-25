package racingcar.validator;

import static racingcar.constant.ErrorMessage.DUPLICATED_CAR_NAME;
import static racingcar.constant.ErrorMessage.INVALID_NAME_CONTAINS_SPACE;
import static racingcar.constant.ErrorMessage.INVALID_NAME_FORMAT;
import static racingcar.constant.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.constant.GameRule.MAX_CAR_COUNT;
import static racingcar.constant.GameRule.MAX_NAME_LENGTH;
import static racingcar.constant.GameRule.MIN_CAR_COUNT;

import java.util.HashSet;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class CarValidator {
    private CarValidator() {}

    public static void validate(List<String> names) {
        names.forEach(CarValidator::validateNameFormat);
        validateDuplicateNames(names);
        validateCarCount(names);
    }

    static void validateDuplicateNames(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME);
        }
    }

    static void validateCarCount(List<String> names) {
        if (names.size() < MIN_CAR_COUNT || names.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_COUNT);
        }
    }

    static void validateNameFormat(String name) {
        validateNoSpace(name);
        validateNameIsEnglish(name);
        validateNameLength(name);
    }

    static void validateNoSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(INVALID_NAME_CONTAINS_SPACE);
        }
    }

    static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    static void validateNameIsEnglish(String name) {
        if (!name.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException(INVALID_NAME_FORMAT);
        }
    }
}
