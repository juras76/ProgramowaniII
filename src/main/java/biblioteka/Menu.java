package biblioteka;

import com.google.common.collect.Lists;
import lombok.Value;
import lombok.val;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static afu.org.checkerframework.checker.units.UnitsTools.cd;

public class Menu {

    public String getSciezkaPliku() {
        return sciezkaPliku;
    }

    String sciezkaPliku;
    String wybrano, parametry;
    private int znak;
    public List<Biblioteka> zbiorCD = new ArrayList<>();
    private Biblioteka zbiorCd;

    public void setSciezkaPliku(String sciezkaPliku) {
        Settings.file = sciezkaPliku;
    }

    public void wyjscieZProgramu() {
        System.out.println("Dziękujemy za zakup naszego produktu :-)");
        return;
    }

    public void parametryProgramu() {
        Settings file;
        System.out.println("Podaj ścieżkę do katalogu płyt (lokalizacja domyślna: " + Settings.file + ")");
        Scanner sc = new Scanner(System.in);
        setSciezkaPliku(sc.nextLine());
        System.out.println("Nowa lokalizacja pliku z płytami: " + Settings.file);
    }

    public void wyszukajCD(Biblioteka zbiorCd) {

        String nazwaCD, wykonawcaCD, gatunekCD, tytulUtworu;

        List<CD> listaCD = new ArrayList<>();

        double dlUtworuMin, dlUtworuMax;

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj parametry wyszukiwania naciskając ENTER, puste -  oznacza wybranie wszystkich");

        System.out.print("Tytuł cd: ");
        nazwaCD = sc.nextLine();

        if (nazwaCD.length() != 0) {
            List<CD> listaCDFiltr = zbiorCd.listaCD.stream().
                    filter(cd -> cd.tytulPlyty.toUpperCase().contains((nazwaCD).toUpperCase())).collect(Collectors.toList());
            if (!listaCDFiltr.isEmpty()) {
                zbiorCd.listaCD.clear();
                zbiorCd.listaCD.addAll(listaCDFiltr);
            }
        }

        System.out.print("Wykonawca cd: ");
        wykonawcaCD = sc.nextLine();
        if (wykonawcaCD.length() != 0) {
            List<CD> listaCDFiltr = zbiorCd.listaCD.stream().
                    filter(cd -> cd.wykonawcaPlyty.toUpperCase().contains((wykonawcaCD).toUpperCase())).collect(Collectors.toList());
            if (!listaCDFiltr.isEmpty()) {
                zbiorCd.listaCD.clear();
                zbiorCd.listaCD.addAll(listaCDFiltr);
            }
        }

        System.out.print("Gatunek cd: ");
        gatunekCD = sc.nextLine();
        if (gatunekCD.length() != 0) {
            List<CD> listaCDFiltr = zbiorCd.listaCD.stream().
                    filter(cd -> cd.gatunekPlyty.toUpperCase().contains((gatunekCD).toUpperCase())).collect(Collectors.toList());
            if (!listaCDFiltr.isEmpty()) {
                zbiorCd.listaCD.clear();
                zbiorCd.listaCD.addAll(listaCDFiltr);
            }
        }

        System.out.print("Tytuł utworu: ");
        tytulUtworu = sc.nextLine();
        if (tytulUtworu.length() != 0) {
            List<CD> listaCDFiltr = zbiorCd.listaCD.stream().filter(utwor -> {
                List<Utwor> listaUtworowFiltr = utwor.getListaUtworow().stream()
                        .filter(u -> u.nazwaUtworu.toUpperCase().contains(tytulUtworu.toUpperCase())).collect(Collectors.toList());
                return !listaUtworowFiltr.isEmpty();
            }).collect(Collectors.toList());
            if (!listaCDFiltr.isEmpty()) {
                zbiorCd.listaCD.clear();
                zbiorCd.listaCD.addAll(listaCDFiltr);
            }
        }

        System.out.println("Długość utworu dłuższa niż w formacie mm.ss: ");
        dlUtworuMin = sc.nextDouble();
        if (Double.toString(dlUtworuMin).length() > 0 && dlUtworuMin > 0) {
            List<CD> listaCDFiltr = listaCD.stream().filter(utwor -> {
                List<Utwor> listaUtworowFiltr = utwor.getListaUtworow().stream()
                        .filter(u -> u.dlugoscUtworu >= dlUtworuMin)
                        .collect(Collectors.toList());
                return !listaUtworowFiltr.isEmpty();
            }).collect(Collectors.toList());
            if (!listaCDFiltr.isEmpty()) {
                listaCD.clear();
                listaCD.addAll(listaCDFiltr);
            }
        } else {
            System.out.println("Podałeś czas mniejszy od 0 lub w nieprawidłowym formacie!");
            return;
        }

        System.out.println("Długość utworu krótsza niż w fomacie mm.ss: ");
        dlUtworuMax = sc.nextDouble();
        if (Double.toString(dlUtworuMax).length() > 0 && dlUtworuMax > 0) {
            List<CD> listaCDFiltr = listaCD.stream().filter(utwor -> {
                List<Utwor> listaUtworowFiltr = utwor.getListaUtworow().stream()
                        .filter(u -> u.dlugoscUtworu <= dlUtworuMax)
                        .collect(Collectors.toList());
                return !listaUtworowFiltr.isEmpty();
            }).collect(Collectors.toList());
            if (!listaCDFiltr.isEmpty()) {
                listaCD.clear();
                listaCD.addAll(listaCDFiltr);
            }
        } else {
            System.out.println("Podałeś czas mniejszy od 0 lub w nieprawidłowym formacie!");
            return;
        }

        if (zbiorCd.listaCD.size() != 0) {
            wydrukujListeCD(zbiorCd);
        } else {
            System.out.println("Brak wyników wyszukiwania");
        }
    }

    public void wydrukujListeCD(Biblioteka zbiorCd) {
        zbiorCd.listaCD.stream().forEach(cd -> System.out.println(cd));
    }

    public boolean WprowadzonyCzasJestPrawidlowy(double czas) {
        final String regexCzas1 = "[0-9]{1,2}[,][0-9]{1,2}";
        final String regexCzas2 = "[0-9]{1,2}[.][0-9]{1,2}";

        String stringCzas = Double.toString(czas);
        return (Pattern.matches(regexCzas1, stringCzas) || Pattern.matches(regexCzas1, stringCzas)) ? true : false;
    }

    public void dodajCD() {

        List<Biblioteka> zbiorCd = new ArrayList<>();
        List<CD> cd = new ArrayList<>();
        List<Utwor> listaUtworow = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Dodawanie płyty do zbioru płyt");
        System.out.println("Podaj ciąg definiujący cd w formacie\n" +
                "#nrCD#tytulCD#wykonawcaCD#gatunekCD#@nrUtoworu1@tytulUtworu1@czasUtworu1@.....@\n" +
                "Pola odnoszące się do CD oddzielaj znakami #, pola odnoszące się do utworów znakami @np.\n" +
                "#cd121#The best#Sting#POP#@1@Sting on tour@2.56@2@Hello World@ 10.59@"
        );

        //int suma(int arg0, int...args)
        //podziel stringa w zaleznopsci od znaku
        //jezeli napotkasz @ to kolejne argumenty oddzielone @ wrzuc do listaUtworow
        //jezeli napotkasz # to pobierz kolejno nrCD,tytulCD,wykonawcaCD,gatunekCD
        //dorzuć do tego listę Uworow
        //utworz obiekt CD
        //dodaj CD do zbioruCd

    }

    public void usunCD(Biblioteka zbiorCd) {

        List<Biblioteka> zbiorCD = new ArrayList<>();
        List<Biblioteka> zbiorCDOut = new ArrayList<>();
        List<CD> listaCdOut = new ArrayList<>();

        zbiorCDOut.clear();

        String idCD;
        System.out.println("Podaj id płyty w formacie idXXX");
        Scanner sc = new Scanner(System.in);
        idCD = sc.nextLine();
        int indexElementu = 0;

        int rozmiarListyIn;
        int rozmiarListyOut;
        if (idCD.length() != 0) {
            List<CD> listaCDFiltr = zbiorCd.listaCD.stream().collect(Collectors.toList());
            rozmiarListyOut = rozmiarListyIn = listaCDFiltr.size();
            for (CD cd : listaCDFiltr) {
                if (cd.idPlyty.toUpperCase().equals(idCD.toUpperCase())) {
                    indexElementu = zbiorCd.listaCD.indexOf(cd);
                    listaCdOut.add(cd);
                    rozmiarListyOut--;
                }
            }
            if (rozmiarListyOut < rozmiarListyIn) {
                //System.out.println(rozmiarListyIn + " " + rozmiarListyOut + " " + indexElementu + " ");
                zbiorCd.listaCD.remove(indexElementu);
                //}
            }else {
                System.out.println("Brak płyty o id = " + idCD);
            }
        } else {
            System.out.println("ID płyty nie może być puste");
        }

        wydrukujListeCD(zbiorCd);
    }

        /*if (idCD.length() != 0) {
            List<CD> listaCDFiltr = zbiorCd.listaCD.stream().
                    filter(cd -> cd.idPlyty.toUpperCase().equals(idCD.toUpperCase())).collect(Collectors.toList());
            if (!listaCDFiltr.isEmpty()) {
                for(int i=0; i==zbiorCd.getListaCD().size();i++){
                    // jezeli idCD znajdzie sie w zbiorze to pomin, a jezeli nie znajdzie to wrzuc do nowej listyif (
                }
                zbiorCd.listaCD.clear();
                zbiorCd.listaCD.addAll(listaCDFiltr);
            }
            for (CD cd:listaCDFiltr){
                System.out.println(cd);
            }
        }*/

        //wydrukujListeCD(listaCDFiltr);
    }