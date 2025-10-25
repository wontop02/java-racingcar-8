package racingcar.validator;

import static racingcar.constant.ErrorMessage.DUPLICATED_CAR_NAME;
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
        validateDuplicateNames(names);
        validateCarCount(names);
        names.forEach(CarValidator::validateNameFormat);
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
        validateNameLength(name);
        validateNameIsEnglish(name);
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
