import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class MenuTest {
    @Test
    public void WrowadzonyCzasJestPrawidlowy(double czas) {
        //Given
        final String regexCzas = "[0-9]{1,2}[.][0-9]{2}";
        double Czas = 12.34;
        String stringCzas = Double.toString(czas);
        //When
        boolean formatCzasu = Pattern.matches(regexCzas, stringCzas);
        //Then
        Assert.assertTrue(formatCzasu);
    }
}
