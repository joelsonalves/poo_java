import java.util.Random;

public class Main {
    
    public static void main(String[] args) {

        double altura = new Random().nextDouble(3);
        double peso = new Random().nextDouble(50);

        System.out.printf("Altura: %.2f e Peso: %.2f.\n", altura, peso);

        try {
            Animal animal = new Cachorro(altura, peso, false);
            animal.setAltura(1.5);
            animal.emitirSom();
            ((Cachorro) animal).setAdestrado();
        } catch(AlturaAnimalException e) {
            System.out.println("A altura não atende a especificação.");
        } catch(PesoAnimalException e) {
            System.out.println("O peso não atende a especificação.");
        }

    }

}
