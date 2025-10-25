package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

public class InputViewTest {
    static final int MAX_ATTEMPT_COUNT = 30;
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "a,b,c,d,e,f,g,h"})
    void 자동차_개수는_min_이상_max_이하가_아니면_예외가_발생한다(String input) {
        int min = 2;
        int max = 7;
        assertThatThrownBy(() -> InputView.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 " + min + "대 이상, " + max + "대 이하로 입력해야 합니다.");
    }

    @Test
    void 시도할_횟수는_숫자를_제외한_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.parseAttemptCount("1.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1-" + MAX_ATTEMPT_COUNT + " 사이의 정수로 입력해야 합니다.");
    }
}
