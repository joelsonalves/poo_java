public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new PessoaFisica("José Maria", "012.234.456-78");
        Pessoa p2 = new PessoaJuridica("Empresa X", "12.345.567/0001-76");
        Pessoa[] pessoas = {p1, p2};
        for (Pessoa p : pessoas) {
            p.socializar();
            System.out.println(p.getClass() + "\n");
        }
    }
}
