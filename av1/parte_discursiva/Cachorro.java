public class Cachorro extends Animal {

    private boolean adestrado;

    public Cachorro(double altura, double peso, boolean adestrado) throws AlturaAnimalException, PesoAnimalException {
        super(altura, peso);
        this.adestrado = adestrado;
    }

    public boolean getAdestrado() {
        return adestrado;
    }

    public void setAdestrado() {
        this.adestrado = true;
    }

    @Override
    public void emitirSom() {
        System.out.println("Auuuu...");
    }
    
}
