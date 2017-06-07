import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Marlon Suyo on 6/5/2017.
 */
public class BerlinClockTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ifNullInputExceptionThrown() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The input entered is empty.");
        BerlinClock berlinClock = new BerlinClock(null);
    }

    @Test
    public void ifEmptyInputExceptionThrown() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The input entered is empty.");
        BerlinClock berlinClock = new BerlinClock("");
    }

    @Test
    public void ifNotInProperHhMmSsSemicolonFormatCaseOneExceptionThrown() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The input entered is not in the valid format of HH:MM:SS.");
        BerlinClock berlinClock = new BerlinClock("12:34");
    }

    @Test
    public void ifNotInProperHhMmSsSemicolonFormatCaseTwoExceptionThrown() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The input entered is not in the valid format of HH:MM:SS.");
        BerlinClock berlinClock = new BerlinClock("12:34:56:00");
    }

   /* @Test
    public void ifTimeDoesNotHaveValidNumbersExceptionThrown() throws Exception {
        try {
            BerlinClock berlinClock = new BerlinClock("ma:rl:on");
            fail("The input entered is not in the valid format of HH:MM:SS.");
        }
        catch (IllegalArgumentException iae) {
            assertThat(iae.getMessage(), containsString("The input entered is not in the valid format of HH:MM:SS."));
        }

    }*/

    @Test
    public void ifTimeIsOutOfBoundsExceptionThrown() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The input entered is out of bounds of a valid time.");
        BerlinClock berlinClock = new BerlinClock("24:-1:60");
    }

    @Test
    public void whenSecondsAreOddDisplayOff() throws Exception {
        BerlinClock berlinClock = new BerlinClock("23:23:01");
        String actual = berlinClock.getBerlinTime().substring(0, 1);

        String expected = "O";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void whenSecondsAreEvenDisplayYellow() throws Exception {
        BerlinClock berlinClock = new BerlinClock("23:23:00");
        String actual = berlinClock.getBerlinTime().substring(0, 1);

        String expected = "Y";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void whenFiveHrBlocksGreaterOrEqualTwentyDisplayAllRed() throws Exception {
        BerlinClock berlinClock = new BerlinClock("20:00:00");
        String actual = berlinClock.getBerlinTime().substring(1, 5);

        String expected = "RRRR";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void whenFiveHrBlocksLessFiveDisplayAllOff() throws Exception {
        BerlinClock berlinClock = new BerlinClock("04:00:00");
        String actual = berlinClock.getBerlinTime().substring(1, 5);

        String expected = "OOOO";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void whenOneHrBlocksEqualFourDisplayAllRed() throws Exception {
        BerlinClock berlinClock = new BerlinClock("04:00:00");
        String actual = berlinClock.getBerlinTime().substring(5, 9);

        String expected = "RRRR";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void whenOneHrBlocksEqualZeroDisplayAllOff() throws Exception {
        BerlinClock berlinClock = new BerlinClock("00:59:59");
        String actual = berlinClock.getBerlinTime().substring(5, 9);

        String expected = "OOOO";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void whenFiveMinBlocksGreaterEqualFiftyfiveDisplayAllLights() throws Exception {
        BerlinClock berlinClock = new BerlinClock("00:55:00");
        String actual = berlinClock.getBerlinTime().substring(9, 20);

        String expected = "YYRYYRYYRYY";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void whenFiveMinBlocksLessFiveDisplayAllOff() throws Exception {
        BerlinClock berlinClock = new BerlinClock("23:04:59");
        String actual = berlinClock.getBerlinTime().substring(9, 20);

        String expected = "OOOOOOOOOOO";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void whenOneMinBlocksEqualFourDisplayAllYellow() throws Exception {
        BerlinClock berlinClock = new BerlinClock("00:04:00");
        String actual = berlinClock.getBerlinTime().substring(20, 24);

        String expected = "YYYY";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void whenOneMinBlocksEqualZeroDisplayAllOff() throws Exception {
        BerlinClock berlinClock = new BerlinClock("23:00:59");
        String actual = berlinClock.getBerlinTime().substring(20, 24);

        String expected = "OOOO";

        assertThat(actual, is(equalTo(expected)));
    }
}