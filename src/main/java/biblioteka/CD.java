package biblioteka;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class CD {

    String idPlyty;
    String tytulPlyty;
    String wykonawcaPlyty;
    String gatunekPlyty;
    List<Utwor> listaUtworow = new ArrayList<>();
}
