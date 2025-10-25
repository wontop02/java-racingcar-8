package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private OutputView() {}

    public static void printCarPosition(Car car) {
        System.out.println(car.name() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
