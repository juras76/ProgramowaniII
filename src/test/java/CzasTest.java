import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CzasTest {

    @Test
    public void FormatStringuDatyOK() {
        //Given
        final String regex = "[0-9]{1,2} h [0-9]{1,2} min";
        String czasString = "12 h 58 min";
        //When
        boolean formatOK = Pattern.matches(regex, czasString);
        //Then
        Assert.assertTrue(formatOK);
    }

    @Test
    public void FormatStringuDatyNotOk() {
        //Given
        final String regex = "[0-9]{1,2} h [0-9]{1,2} min";
        String czasString = "12 h 5 min p.m.";
        //When
        boolean format = Pattern.matches(regex, czasString);
        //Then
        Assert.assertFalse(format);
    }

    @Test
    public void WrowadzonaGodzinaJestCyfraLub2Cyfry() {
        //Given
        final String regexGodz = "[0-9]{1,2}";
        int godz = 12;
        String godzString = Integer.toString(godz);
        //When
        boolean format = Pattern.matches(regexGodz, godzString);
        //Then
        Assert.assertTrue(format);
    }

    @Test
    public void WrowadzonaGodzinaNieJestCyfraLub2Cyframi() {
        //Given
        final String regexGodz = "[0-9]{1,2}";
        String godzString = "2g";
        //When
        boolean format = Pattern.matches(regexGodz, godzString);
        //Then
        Assert.assertFalse(format);
    }

    @Test
    public void WrowadzonaMinutaNieJestCyfraLub2Cyframi() {
        //Given
        final String regexMinuty = "[0-9]{1,2}";
        String minutyString = "1m";
        //When
        boolean format = Pattern.matches(regexMinuty, minutyString);
        //Then
        Assert.assertFalse(format);
    }

    @Test
    public void testToStringOK() {
        //Given
        Czas czas = new Czas(13, 57);
        //when
        String czasResult = czas.toString();
        //then
        Assert.assertEquals("13 h 57 min", czasResult);
    }

    @Test
    public void testToStringNotOk() {
        //Given
        Czas czas = new Czas(13, 57);
        //when
        String czasResult = czas.toString();
        //then
        Assert.assertNotEquals("13 h 59 min", czasResult);
    }

    @Test
    public void testdodajCzasOk() {
        //Given
        Czas czas = new Czas(13, 13);
        Czas czasIn = new Czas(1, 1);
        //when
        String czasResult = czas.dodajCzas(czasIn);
        //then
        Assert.assertEquals("14 h 14 min", czasResult);
    }

    @Test
    public void testdodajCzasNotOk() {
        //Given
        Czas czas = new Czas(13, 13);
        Czas czasIn = new Czas(2, 2);
        //when
        String czasResult = czas.dodajCzas(czasIn);
        //then
        Assert.assertNotEquals("14 h 14 min", czasResult);
    }

    @Test
    public void testodejmijCzasOk() {
        //Given
        Czas czas = new Czas(13, 13);
        Czas czasIn = new Czas(1, 1);
        //when
        String czasResult = czas.odejmijCzas(czasIn);
        //then
        Assert.assertEquals("12 h 12 min", czasResult);
    }

    @Test
    public void testodejmijCzasNotOk() {
        //Given
        Czas czas = new Czas(13, 13);
        Czas czasIn = new Czas(3, 3);
        //when
        String czasResult = czas.odejmijCzas(czasIn);
        //then
        Assert.assertNotEquals("12 h 12 min", czasResult);
    }
    @Test
    public void testpomnozCzasOk() {
        //Given
        Czas czasIn = new Czas(1, 13);
        //when
        String czasResult = czasIn.pomnozCzas(2);
        //then
        Assert.assertEquals("2 h 26 min", czasResult);
    }

    @Test
    public void testpomnozCzasNotOk() {
        //Given
        Czas czasIn = new Czas(13, 13);
        //when
        String czasResult = czasIn.pomnozCzas(2);
        //then
        Assert.assertNotEquals("16 h 16 min", czasResult);
    }

}