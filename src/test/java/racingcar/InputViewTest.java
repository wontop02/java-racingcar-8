package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "a,b,c,d,e,f,g,h"})
    void 자동차_개수는_min_이상_max_이하가_아니면_예외가_발생한다(String input) {
        int min = 2;
        int max = 7;
        assertThatThrownBy(() -> InputView.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 " + min + "대 이상, " + max + "대 이하로 입력해야 합니다.");
    }
}
