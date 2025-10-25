package racingcar.domain;

import static racingcar.constant.ErrorMessage.DUPLICATED_CAR_NAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private int attemptCount;

    public RacingGame(List<String> carNames, int attemptCount) {
        cars = createCars(carNames);
        this.attemptCount = attemptCount;
    }

    private List<Car> createCars(List<String> carNames) {
        validateDuplicateNames(carNames);
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateDuplicateNames(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME);
        }
    }

    public void moveCars() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
        attemptCount--;
    }

    int getAttemptCount() {
        return attemptCount;
    }

    public boolean isFinished() {
        if (attemptCount <= 0) {
            return true;
        }
        return false;
    }
}
