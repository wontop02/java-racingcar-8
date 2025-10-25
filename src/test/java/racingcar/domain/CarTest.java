package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"javaji", ""})
    void 자동차_이름은_1자_이상_max자_이하가_아니면_예외가_발생한다(String name) {
        int max = 5;
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, " + max + "자 이하로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"포비p", "pobi1"})
    void 자동차_이름이_영어로만_구성되어_있지_않으면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 영어로만 입력해야 합니다.");
    }
}
