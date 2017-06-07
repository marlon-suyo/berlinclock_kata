import java.util.Collections;

public class BerlinClock {

    private String berlinTime;

    private static final String EMPTY_INPUT = "The input entered is empty.";
    private static final String INVALID_INPUT = "The input entered is not in the valid format of HH:MM:SS.";
    private static final String OUT_OF_BOUNDS_INPUT = "The input entered is out of bounds of a valid time.";


    public BerlinClock(String input) {
        if(input == null || input.equals("")) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }

        String[] time = input.split(":", 3);
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        if(time.length != 3 || time[2].contains(":"))
            throw new IllegalArgumentException(INVALID_INPUT);

        try {
            hours = Integer.parseInt(time[0]);
            minutes = Integer.parseInt(time[1]);
            seconds = Integer.parseInt(time[2]);
        }
        catch (IllegalArgumentException iae) {
            System.out.println(INVALID_INPUT);
        }

        berlinTime = convertClockInputToString(hours, minutes, seconds);
    }

    public String getBerlinTime() {
        return berlinTime;
    }

    private String convertClockInputToString(int hours, int minutes, int seconds) {
        if(hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59)
            throw new IllegalArgumentException(OUT_OF_BOUNDS_INPUT);

        int singleSeconds = seconds % 2;
        String secondsRow = parseRow(singleSeconds, BlockOfTime.SECONDS);

        int fiveHours = hours / 5;
        String fiveHoursRow = parseRow(fiveHours, BlockOfTime.FIVE_HRS);
        //System.out.println("5 hrs: " + fiveHoursRow);

        int singleHours = hours % 5;
        String singleHoursRow = parseRow(singleHours, BlockOfTime.ONE_HR);
        //System.out.println("1 hrs: " + singleHoursRow);

        int fiveMinutes = minutes / 5;
        String fiveMinutesRow = parseRow(fiveMinutes, BlockOfTime.FIVE_MINS);
       // System.out.println("5 min: " + fiveMinutesRow);

        int singleMinutes = minutes % 5;
        String singleMinutesRow = parseRow(singleMinutes, BlockOfTime.ONE_MIN);
        //System.out.println("1 min: " + singleMinutesRow);

        return secondsRow + fiveHoursRow + singleHoursRow + fiveMinutesRow + singleMinutesRow;
    }

    private String parseRow(int input, BlockOfTime blockOfTime) {
        int numberOfElementsInRow = blockOfTime.showUnitsInRow();

        String row = String.join("", Collections.nCopies(input, "Y"));
        row += String.join("", Collections.nCopies(numberOfElementsInRow-input, "O"));

        if(blockOfTime == BlockOfTime.FIVE_MINS)
            row = row.replace("YYY","YYR");

        if(blockOfTime == BlockOfTime.ONE_HR || blockOfTime == BlockOfTime.FIVE_HRS) {
            row = row.replace('Y', 'R');
        }

        if(blockOfTime == BlockOfTime.SECONDS) {
            if(row.equals("Y"))
                row = row.replace('Y', 'O');
            else
                row = row.replace('O', 'Y');
        }

        return row;
    }
}