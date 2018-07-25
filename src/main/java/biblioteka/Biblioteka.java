package biblioteka;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class Biblioteka {

    List<CD> listaCD = new ArrayList<>();
}
