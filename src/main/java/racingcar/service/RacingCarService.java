package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarService {
    private static final String CAR_SEPARATOR = ",";
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    public List<RacingCar> makeCars(String input) {
        List<String> names = Arrays.asList(input.split(CAR_SEPARATOR, -1));
        return names.stream()
                .map(RacingCar::new)
                .toList();
    }

    public void moveCar(RacingCar car) {
        int random = pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        car.move(random);
    }

    public List<String> findWinnerNames(List<RacingCar> cars) {
        int maxLocation = findMaxLocation(cars);
        List<RacingCar> winners = cars.stream()
                .filter(c -> c.getLocation() == maxLocation)
                .toList();
        return winners.stream()
                .map(RacingCar::getName)
                .toList();
    }

    private int findMaxLocation(List<RacingCar> cars) {
        int maxLocation = 0;
        for (RacingCar car : cars) {
            if (car.getLocation() > maxLocation) {
                maxLocation = car.getLocation();
            }
        }
        return maxLocation;
    }
}
