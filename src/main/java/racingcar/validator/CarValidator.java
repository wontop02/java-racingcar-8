package racingcar.validator;

import static racingcar.constant.ErrorMessage.INVALID_NAME_FORMAT;
import static racingcar.constant.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.constant.GameRule.MAX_NAME_LENGTH;

public class CarValidator {
    private CarValidator() {}

    public static void validateNameFormat(String name) {
        validateNameLength(name);
        validateNameIsEnglish(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private static void validateNameIsEnglish(String name) {
        if (!name.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException(INVALID_NAME_FORMAT);
        }
    }
}
