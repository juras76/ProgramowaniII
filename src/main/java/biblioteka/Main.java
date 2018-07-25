package biblioteka;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
@AllArgsConstructor

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Users user = new Users();
        char znak;
        String userIn, passwordIn;

        List<CD> cd = new ArrayList<>();
        List<Biblioteka> zbior = new ArrayList<>();

        Utwor utwor1_1 = new Utwor(1, "Tata Dilera", 2.45);
        Utwor utwor1_2 = new Utwor(2, "Dziewczyny", 3.45);
        Utwor utwor1_3 = new Utwor(3, "Chłopcy", 4.45);
        Utwor utwor1_4 = new Utwor(4, "Pary", 5.45);
        Utwor utwor1_5 = new Utwor(5, "Tata", 1.45);
        Utwor utwor1_6 = new Utwor(6, "Dilera", 2.45);
        Utwor utwor1_7 = new Utwor(7, "Tata dziewczyny", 3.45);
        Utwor utwor1_8 = new Utwor(8, "Tata chłpców", 4.45);
        Utwor utwor2_1 = new Utwor(1, "AAA", 5.45);
        Utwor utwor2_2 = new Utwor(2, "AAABBB", 6.45);
        Utwor utwor2_3 = new Utwor(3, "BBBCCC", 7.45);
        Utwor utwor2_4 = new Utwor(4, "CCCDDD", 2.45);
        Utwor utwor2_5 = new Utwor(5, "DDDEEE", 3.45);
        Utwor utwor2_6 = new Utwor(6, "EEEE", 4.45);
        Utwor utwor2_7 = new Utwor(7, "D", 1.45);
        Utwor utwor2_8 = new Utwor(8, "C", 13.45);
        Utwor utwor3_1 = new Utwor(1, "1", 1.45);
        Utwor utwor3_2 = new Utwor(2, "2", 2.45);
        Utwor utwor3_3 = new Utwor(3, "12", 3.45);
        Utwor utwor3_4 = new Utwor(4, "21", 4.45);
        Utwor utwor3_5 = new Utwor(5, "22", 5.45);
        Utwor utwor4_1 = new Utwor(1, "123EE", 6.45);
        Utwor utwor4_2 = new Utwor(2, "321DD", 7.45);
        Utwor utwor4_3 = new Utwor(3, "231CC", 8.45);
        Utwor utwor4_4 = new Utwor(4, "213AA", 1.45);
        Utwor utwor4_5 = new Utwor(5, "21B", 3.45);
        Utwor utwor4_6 = new Utwor(6, "32C", 2.45);
        Utwor utwor4_7 = new Utwor(7, "23D", 7.45);
        Utwor utwor4_8 = new Utwor(8, "13DD", 4.45);
        Utwor utwor4_9 = new Utwor(9, "33EEE", 6.45);

        CD cd01 = new CD("cd01", "Tata Kazika 2", "Kazik", "Rock",
                Lists.newArrayList(utwor1_1, utwor1_2, utwor1_3, utwor1_4, utwor1_5, utwor1_6, utwor1_7, utwor1_8));
        CD cd02 = new CD("cd02", "Literki", "Alfabet", "Rock",
                Lists.newArrayList(utwor2_1, utwor2_2, utwor2_3, utwor2_4, utwor2_5, utwor2_6, utwor2_7, utwor2_8));
        CD cd03 = new CD("cd03", "Cyferki", "Arabski", "Disco",
                Lists.newArrayList(utwor3_1, utwor3_2, utwor3_3, utwor3_4, utwor3_5));
        CD cd04 = new CD("cd04", "LiterkoCyferki", "Slowiki", "Klasyczna",
                Lists.newArrayList(utwor4_1, utwor4_2, utwor4_3, utwor4_4, utwor4_5, utwor4_6, utwor4_7, utwor4_8, utwor4_9));

        Biblioteka zbiorCD = new Biblioteka(Lists.newArrayList(cd01, cd02, cd03, cd04));

        cd.stream().forEach(utwor -> System.out.println(utwor));
        zbiorCD.listaCD.stream().forEach(cdv -> System.out.println(cdv));


        //List<Biblioteka> zbiorCD = (List<Biblioteka>) new Biblioteka(Lists.newArrayList(cd01, cd02, cd03, cd04));

        /*List<Biblioteka> zbiorCD = new ArrayList<>();
        zbiorCD.addAll(cd);*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Program do wyszukiwania płyt CD dla zadanych parametrów");
        System.out.print("Podaj użytkownika: ");
        userIn = sc.nextLine().toUpperCase();
        System.out.print("Podaj hasło: ");
        passwordIn = sc.nextLine().toUpperCase();
        if (user.checkLogin(userIn, passwordIn)) {
            do {
                System.out.println("Wybierz pozycję menu: ");
                System.out.println("e(X)it, (P)rint all, (F)ind & Print, (A)dd new CD, (R)emove CD, (C)hange CD, (S)ettings");
                sc = new Scanner(System.in);
                znak = sc.next().toUpperCase().charAt(0);
                switch (znak) {
                    case 'X': {menu.wyjscieZProgramu();break;}
                    case 'S': {menu.parametryProgramu();break;}
                    case 'F': {menu.wyszukajCD(zbiorCD);break;}
                    case 'P': {menu.wydrukujListeCD(zbiorCD);break;}
                    //case 'A': {menu.dodajCD();break;}
                    case 'R': {menu.usunCD(zbiorCD); break;}
                    //case 'C': {menu.edytujCD(CD); break;}
                    default: {
                        System.out.println("Wybór nieprawidłowy!");
                    }
                }
            }while (znak!='X');
        } else {
            System.out.println("Logowanie do systemu niepoprawne! Spadaj !!!");
            //return;
        }
    }
}