public abstract class Animal {
    
    private double altura;
    private double peso;

    public Animal(double altura, double peso) throws AlturaAnimalException, PesoAnimalException {
        setAltura(altura);
        setPeso(peso);
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) throws AlturaAnimalException {
        if (altura >= 0.5 && altura <= 1.5) {
            this.altura = altura;
        } else {
            throw new AlturaAnimalException();
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) throws PesoAnimalException {
        if (peso >= 10 && peso <= 30.5) {
            this.peso = peso;
        } else {
            throw new PesoAnimalException();
        }
    }

    public abstract void emitirSom();

}
