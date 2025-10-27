package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private OutputView() {}

    public static void printCarPosition(List<Car> cars) {
        cars.forEach(car ->
                System.out.println(car.name() + " : " + car.drawPosition())
        );
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
