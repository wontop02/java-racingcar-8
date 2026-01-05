package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarService {
    private static final String CAR_SEPARATOR = ",";

    public List<RacingCar> makeCars(String input) {
        List<String> names = Arrays.asList(input.split(CAR_SEPARATOR, -1));
        return names.stream()
                .map(RacingCar::new)
                .toList();
    }
}
