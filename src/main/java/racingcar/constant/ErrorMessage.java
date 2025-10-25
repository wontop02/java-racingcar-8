package racingcar.constant;

import static racingcar.constant.GameRule.MAX_CAR_COUNT;
import static racingcar.constant.GameRule.MAX_NAME_LENGTH;
import static racingcar.constant.GameRule.MIN_CAR_COUNT;

public class ErrorMessage {
    private ErrorMessage() {}

    public static final String INVALID_CAR_COUNT =
            "자동차는 " + MIN_CAR_COUNT + "대 이상, " + MAX_CAR_COUNT + "대 이하로 입력해야 합니다.";

    public static final String INVALID_NAME_LENGTH =
            "자동차 이름은 1자 이상, " + MAX_NAME_LENGTH + "자 이하로 입력해야 합니다.";
    public static final String INVALID_NAME_FORMAT =
            "자동차 이름은 영어로만 입력해야 합니다.";

    public static final String DUPLICATED_CAR_NAME =
            "자동차 이름은 중복될 수 없습니다.";
}
