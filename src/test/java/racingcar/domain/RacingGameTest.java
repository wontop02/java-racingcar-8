package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;

public class RacingGameTest {
    @Test
    void 중복된_자동차_이름이_존재하면_예외가_발생한다() {
        List<String> carNames = List.of("pobi", "woni", "pobi");
        assertThatThrownBy(() -> new RacingGame(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}
