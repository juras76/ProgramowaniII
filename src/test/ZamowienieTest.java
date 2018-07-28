import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ZamowienieTest {



    @Test
    public void dodajPozycje() {
        Pozycja towar8 = new Pozycja("kokos", 2, 40.00);
        Zamowienie zamowienie1 = new Zamowienie();

    }

    @Test
    public void obliczWartosc() {
        //Given
        Pozycja towar2 = new Pozycja("Mleko", 1, 2.00);
        Pozycja towar3 = new Pozycja("Masło", 1, 4.00);
        Pozycja towar4 = new Pozycja("Ser", 1, 5.00);

        Zamowienie zamowienie2 = new Zamowienie();

        zamowienie2.dodajPozycje(towar2);
        zamowienie2.dodajPozycje(towar3);
        zamowienie2.dodajPozycje(towar4);

        //When
        Double wartosc = zamowienie2.obliczWartosc();
        //Then

        assertEquals(Double.valueOf(11.00), Double.valueOf(zamowienie2.obliczWartosc()));

    }

    @Test
    public void getPozycje() {
        //Given

        //When

        //Then
    }

    @Test
    public void getIleDodanych() {
        //Given

        //When

        //Then
    }

    @Test
    public void getMaksRozmiar() {
        //Given

        //When

        //Then
    }

    @Test
    public void setPozycje() {
        //Given

        //When

        //Then
    }

    @Test
    public void setIleDodanych() {
        //Given

        //When

        //Then
    }

    @Test
    public void setMaksRozmiar() {
        //Given

        //When

        //Then
    }
}