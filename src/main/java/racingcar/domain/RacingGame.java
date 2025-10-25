package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private int attemptCount;

    public RacingGame(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void moveCars() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
        attemptCount--;
    }

    public List<String> decideWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::name)
                .toList();
    }

    public boolean isFinished() {
        return attemptCount <= 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    int getAttemptCount() {
        return attemptCount;
    }
}
