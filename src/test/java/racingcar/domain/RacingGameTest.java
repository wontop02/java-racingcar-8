package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    void 중복된_자동차_이름이_존재하면_예외가_발생한다() {
        List<String> carNames = List.of("pobi", "woni", "pobi");
        assertThatThrownBy(() -> new RacingGame(carNames, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 모든_자동차의_전진_혹은_정지가_결정되면_시도_횟수가_1_감소한다() {
        List<String> carNames = List.of("pobi", "woni");
        int attemptCount = 3;
        RacingGame racingGame = new RacingGame(carNames, attemptCount);
        racingGame.moveCars();
        assertEquals(racingGame.getAttemptCount(), 2);
    }
}
