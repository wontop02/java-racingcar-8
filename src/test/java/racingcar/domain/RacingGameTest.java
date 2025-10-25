package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    void 모든_자동차의_전진_혹은_정지가_결정되면_시도_횟수가_1_감소한다() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));
        RacingGame racingGame = new RacingGame(cars, 3);
        racingGame.moveCars();
        assertEquals(racingGame.getAttemptCount(), 2);
    }

    @Test
    void 시도_횟수가_0이_되면_게임을_종료한다() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));
        RacingGame racingGame = new RacingGame(cars, 1);
        racingGame.moveCars();
        assertTrue(racingGame.isFinished());
    }

    @Test
    void 전진한_횟수가_가장_많은_자동차를_우승자로_선정한다() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        List<Car> cars = List.of(pobi, woni, jun);
        RacingGame racingGame = new RacingGame(cars, 1);
        pobi.move(4);
        woni.move(1);
        jun.move(4);

        List<String> winners = List.of(pobi.name(), jun.name());
        assertEquals(winners, racingGame.decideWinners());
    }
}
