import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carro implements Comparable<Carro> {

    private String placa;

    public Carro() {
        gerarPlaca();
    }

    public String getPlaca() {
        return placa;
    }

    private void gerarPlaca() {
        String placa = "";
        List<Integer> numeros = new ArrayList<Integer>( List.of(3, 5, 6));
        for (int i = 0; i < 7; i++) {
            if (numeros.contains(i)) {
                placa += (char) new Random().nextInt('0', '9' + 1);
            } else {
               placa += (char) new Random().nextInt('A', 'Z' + 1);
            }
        }
        this.placa = placa;
    }

    @Override
    public int compareTo(Carro c) {
        return placa.compareTo(c.getPlaca());
    }

    @Override
    public String toString() {
        return placa;
    }
    
}
