package racingcar.domain;

import static racingcar.constant.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.constant.GameRule.MAX_NAME_LENGTH;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
        validateNameLength(name);
    }

    public void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }
}
