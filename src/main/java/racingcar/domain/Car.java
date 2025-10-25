package racingcar.domain;

import static racingcar.constant.ErrorMessage.INVALID_NAME_FORMAT;
import static racingcar.constant.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.constant.GameRule.MAX_NAME_LENGTH;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        validateNameIsEnglish(name);
        this.name = name;
        this.position = 0;
    }

    public void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public void validateNameIsEnglish(String name) {
        if (!name.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException(INVALID_NAME_FORMAT);
        }
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    int getPosition() {
        return position;
    }
}
