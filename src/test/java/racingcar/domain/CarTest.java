package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차는_무작위_값이_4_이상일_경우에만_전진한다() {
        Car car = new Car("pobi");
        car.move(3);
        assertEquals(0, car.position());
        car.move(4);
        assertEquals(1, car.position());
    }
}
