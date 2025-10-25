package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AttemptCountValidatorTest {
    static final int MAX_ATTEMPT_COUNT = 30;

    @Test
    void 시도할_횟수는_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> AttemptCountValidator.validateInteger("1.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1-" + MAX_ATTEMPT_COUNT + " 사이의 정수로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"9999999999", "-9999999999"})
    void 시도할_횟수는_int_범위를_벗어나면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> AttemptCountValidator.validateWithinIntRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1-" + MAX_ATTEMPT_COUNT + " 사이의 정수로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "31"})
    void 시도할_횟수는_1_이상_max_이하가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> AttemptCountValidator.validateAttemptCountRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1-" + MAX_ATTEMPT_COUNT + " 사이의 정수로 입력해야 합니다.");
    }
}
