package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private int attemptCount;

    public RacingGame(List<String> carNames, int attemptCount) {
        cars = createCars(carNames);
        this.attemptCount = attemptCount;
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void moveCars() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
        attemptCount--;
    }

    int getAttemptCount() {
        return attemptCount;
    }

    public boolean isFinished() {
        return attemptCount <= 0;
    }
}
