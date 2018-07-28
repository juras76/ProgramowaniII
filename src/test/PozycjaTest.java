import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PozycjaTest {

    @Test
    public void obliczWartosc() {
        //Given
        Pozycja towar1 = new Pozycja("Cukier", 3, 4.00);

        //When
        double wartosc = towar1.obliczWartosc();
        //Then
        assertEquals(Double.valueOf(12.00), Double.valueOf(wartosc));

    }

    @Test
    public void testToString() {
        //Given
        Pozycja towar8 = new Pozycja("Papier", 5, 40.00);
        //When
        String lancuch = towar8.toString();
        //Then
        assertEquals(lancuch,towar8.toString() );
    }

    @Test
    public void getNazwaTowaru() {
        //Given
        Pozycja towar3 = new Pozycja("Mleko", 2, 2.00);
        //When
        String nazwa = towar3.getNazwaTowaru();

        //Then

        assertEquals("Mleko", towar3.getNazwaTowaru());
    }

    @Test
    public void getIleSztuk() {
        //Given
        Pozycja towar2 = new Pozycja("Masło", 5, 6.00);
        //When
        int ileSztuk = towar2.getIleSztuk();
        //Then
        assertEquals(5, towar2.getIleSztuk());
    }

    @Test
    public void getCena() {
        //Given
        Pozycja towar4 = new Pozycja("Miód", 10, 30.00);
        //When
        double cena = towar4.getCena();
        //Then
        assertEquals(Double.valueOf(30.00), Double.valueOf(towar4.getCena()));
    }

    @Test
    public void setCena() {
        //Given
        Pozycja towar5 = new Pozycja("Chleb", 1, 10.00);
        //When
        towar5.setCena(20.00);
        //Then
        assertEquals(Double.valueOf(20.00), Double.valueOf(towar5.getCena()));
    }

    @Test
    public void setNazwaTowaru() {
        //Given
        Pozycja towar6 = new Pozycja("Kiełbasa", 5, 25.00);
        //When
        towar6.setNazwaTowaru("Szynka");
        //Then
        assertEquals("Szynka", towar6.getNazwaTowaru());
    }

    @Test
    public void setIleSztuk() {
        //Given
        Pozycja towar7 = new Pozycja("Ser", 2, 50.00);
        //When
        towar7.setIleSztuk(5);
        //Then
        assertEquals(5, towar7.getIleSztuk());
    }
}