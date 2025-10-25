package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.CarValidator;
import racingcar.validator.AttemptCountValidator;

public class InputView {
    private InputView() {}

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return parseCarNames(Console.readLine());
    }

    public static int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return parseAttemptCount(input);
    }

    static List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(",", -1));
        CarValidator.validate(carNames);
        return carNames;
    }

    static int parseAttemptCount(String input) {
        AttemptCountValidator.validate(input);
        return Integer.parseInt(input);
    }
}