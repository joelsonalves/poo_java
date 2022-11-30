import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PesquisaCarro {
    
    public static List<Carro> pesquisar(String placa, Collection<Carro> carros) {
        List<Carro> carrosAux = new ArrayList<Carro>(carros);
        List<Carro> carrosLocalizados = new ArrayList<Carro>();
        for (int i = 0; i < carros.size(); i++) {
            if (carrosAux.get(i).getPlaca().contains(placa)) {
                carrosLocalizados.add(carrosAux.get(i));
            }
        }
        return carrosLocalizados;
    }

}
