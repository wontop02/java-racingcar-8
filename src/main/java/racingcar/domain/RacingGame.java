package racingcar.domain;

import static racingcar.constant.ErrorMessage.DUPLICATED_CAR_NAME;

import java.util.HashSet;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<String> carNames) {
        cars = createCars(carNames);
    }

    public List<Car> createCars(List<String> carNames) {
        validateDuplicateNames(carNames);
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void validateDuplicateNames(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME);
        }
    }
}
