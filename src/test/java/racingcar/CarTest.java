package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void 자동차_이름은_1자_이상_max자_이하가_아니면_예외가_발생한다() {
        int max = 5;
        assertThatThrownBy(() -> new Car("javaji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, " + max + "자 이하로 입력해야 합니다.");
    }

}
