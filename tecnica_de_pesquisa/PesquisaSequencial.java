import java.util.ArrayList;
import java.util.List;

public class PesquisaSequencial {

    public static int pesquisar(Integer valor, List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<Integer>( List.of(5, 8, 34) );
        int a = pesquisar(1, lista);
        int b = pesquisar(34, lista);
        System.out.println(a + " " + b);
    }

}

