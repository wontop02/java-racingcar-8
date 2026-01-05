package racingcar.view;

public class OutputView {
    private static final String PRINT_RESULT = "실행 결과";
    private static final String STATUS_FORMAT = "%s : %s";
    private static final String LOCATION = "-";

    public void printResultStart() {
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
}
