package racingcar.domain;

import racingcar.validator.CarValidator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        CarValidator.validateNameFormat(name);
        this.name = name;
        this.position = 0;
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
