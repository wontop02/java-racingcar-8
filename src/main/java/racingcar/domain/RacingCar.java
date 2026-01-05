package racingcar.domain;

public class RacingCar {
    private static final int MOVE_CRITERIA = 4;

    private final String name;
    private int location;

    public RacingCar(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= MOVE_CRITERIA) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
