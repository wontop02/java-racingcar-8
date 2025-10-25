package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarValidatorTest {
    @Test
    void 중복된_자동차_이름이_존재하면_예외가_발생한다() {
        List<String> carNames = List.of("pobi", "woni", "pobi");
        assertThatThrownBy(() -> CarValidator.validateDuplicateNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 자동차_이름에_공백이_존재할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> CarValidator.validateNoSpace("po bi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 제외하고 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"javaji", ""})
    void 자동차_이름은_1자_이상_max자_이하가_아니면_예외가_발생한다(String name) {
        int max = 5;
        assertThatThrownBy(() -> CarValidator.validateNameLength(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, " + max + "자 이하로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"포비p", "pobi1"})
    void 자동차_이름이_영어로만_구성되어_있지_않으면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> CarValidator.validateNameIsEnglish(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 영어로만 입력해야 합니다.");
    }
}
