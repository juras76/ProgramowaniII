package biblioteka;

public class Settings {

    static String file="\\\\SERVERDELL\\BazaCD\\listaCD.csv";

    public static String getFile() {
        return file;
    }

    public static void setFile(String file) {
        Settings.file = file;
    }
}
