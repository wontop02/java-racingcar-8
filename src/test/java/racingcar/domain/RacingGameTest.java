package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    void 모든_자동차의_전진_혹은_정지가_결정되면_시도_횟수가_1_감소한다() {
        List<String> carNames = List.of("pobi", "woni");
        int attemptCount = 3;
        RacingGame racingGame = new RacingGame(carNames, attemptCount);
        racingGame.moveCars();
        assertEquals(racingGame.getAttemptCount(), 2);
    }

    @Test
    void 시도_횟수가_0이_되면_게임을_종료한다() {
        List<String> carNames = List.of("pobi", "woni");
        int attemptCount = 1;
        RacingGame racingGame = new RacingGame(carNames, attemptCount);
        racingGame.moveCars();
        assertTrue(racingGame.isFinished());
    }
}
