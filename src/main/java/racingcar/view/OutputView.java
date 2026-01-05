package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String STATUS_FORMAT = "%s : %s";
    private static final String LOCATION = "-";
    private static final String WINNER_SEPARATOR = ", ";

    private static final String PRINT_RESULT = "실행 결과";
    private static final String PRINT_WINNERS = "최종 우승자 : ";

    public void printResultStart() {
        System.out.println();
        System.out.println(PRINT_RESULT);
    }

    public void printStatus(String name, int location) {
        String status = LOCATION.repeat(location);
        System.out.printf(STATUS_FORMAT, name, status);
        System.out.println();
    }

    public void printEnter() {
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(PRINT_WINNERS + String.join(WINNER_SEPARATOR, winners));
    }
}
