/**
 * Created by Marlon Suyo on 6/6/2017.
 */
public enum BlockOfTime {
    SECONDS(1), FIVE_HRS(4), ONE_HR(4), FIVE_MINS(11), ONE_MIN(4);

    private final int unitsInRow;

    BlockOfTime(int units) {
        unitsInRow = units;
    }

    int showUnitsInRow() {
        return unitsInRow;
    }
}
