import java.util.ArrayList;
import java.util.List;

public class PesquisaBinaria {
    
    public static int pesquisar(Integer valor, List<Integer> lista) {
        int inicio = 0;
        int meio;
        int fim = lista.size() - 1;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            switch (lista.get(meio).compareTo(valor)) {
                case -1: // Número central menor que o valor
                    inicio = meio + 1;
                    break;
                case 0: // Número central igual ao valor
                    return meio;
                case 1: // Número central menor que o valor
                    fim = meio - 1;
                    break;
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
