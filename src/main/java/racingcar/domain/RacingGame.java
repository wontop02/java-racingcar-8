package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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

    int getAttemptCount() {
        return attemptCount;
    }

    public boolean isFinished() {
        return attemptCount <= 0;
    }

    public List<String> decideWinners() {
        int max = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
                winners = new ArrayList<>();
                winners.add(car.getName());
                continue;
            }
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
