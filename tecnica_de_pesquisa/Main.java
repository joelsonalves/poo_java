import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        SortedSet<Carro> carros = new TreeSet<Carro>();
        
        for (int i = 0; i < 1000; i++) {
            carros.add(new Carro());
        }

        List<Carro> carrosLocalizados = PesquisaCarro.pesquisar("77", carros);

        System.out.println("Carros Localizados: " + carrosLocalizados);

        System.out.println("Quantidade: " + carrosLocalizados.size());

    }
    
}
