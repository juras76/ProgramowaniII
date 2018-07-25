package biblioteka;

import lombok.AllArgsConstructor;
import lombok.Data;
import sun.security.util.Password;

import java.util.Scanner;

public class Users {

    //public String userIn, passwordIn;
    final static String USER="A";
    final static String PASSWORD="A";

    public boolean checkLogin(String userIn, String passwordIn){
        return (userIn.toUpperCase().equals(USER) && passwordIn.toUpperCase().equals(PASSWORD));
    }
}
