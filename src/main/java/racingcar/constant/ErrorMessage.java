package racingcar.constant;

import static racingcar.constant.GameRule.MAX_CAR_COUNT;
import static racingcar.constant.GameRule.MIN_CAR_COUNT;

public class ErrorMessage {
    private ErrorMessage() {}

    public static final String INVALID_CAR_COUNT =
            "자동차는 " + MIN_CAR_COUNT + "대 이상, " + MAX_CAR_COUNT + "대 이하로 입력해야 합니다.";
}
