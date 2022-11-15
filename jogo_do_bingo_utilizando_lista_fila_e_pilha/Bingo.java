import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Bingo {

    private Queue<Integer> bolasSorteadas = new PriorityQueue<Integer>();
    private List<Integer> bolasDisponiveis = new ArrayList<Integer>();

    public static final String ENCERRAR = "0";
    public static final String SORTEAR = "1";
    public static final String LISTAR = "2";
    public static final String REINICIAR = "3";

    public Bingo() {
        reiniciarJogo();
    }

    public Queue<Integer> getBolasSorteadas() {
        return bolasSorteadas;
    }

    public List<Integer> getBolasDisponiveis() {
        return bolasDisponiveis;
    }

    public void listarBolasSorteadas() {
        String texto = "Bola(s) Sorteada(s): ";
        
        if (bolasSorteadas.size() > 0) {
            Integer bola;
            Deque<Integer> pilhaAuxiliar = new ArrayDeque<Integer>();
            for (int i = bolasSorteadas.size() - 1; i >= 0; i--) {
                bola = bolasSorteadas.poll();
                pilhaAuxiliar.offerLast(bola);
                if (bolasSorteadas.size() > 1) {
                    texto += String.format("%02d, ", bola);
                } else if (bolasSorteadas.size() > 0) {
                    texto += String.format("%02d e ", bola);
                } else {
                    texto += String.format("%02d. \n\nNúmero de bola(s) sorteada(s): %02d.", bola, pilhaAuxiliar.size());
                }
            }
            for (int i = pilhaAuxiliar.size() - 1; i >= 0; i--) {
                bolasSorteadas.offer(pilhaAuxiliar.pollLast());
            }
        } else {
            texto += "nenhuma.";
        }
        System.out.println(texto);
    }

    public void sortearBola() {
        if (bolasDisponiveis.size() > 0) {
            int posicao = new Random().nextInt(bolasDisponiveis.size());
            Integer bola = bolasDisponiveis.remove(posicao);
            bolasSorteadas.offer(bola);
            System.out.printf("Bola sorteada: %02d.\n", bola);
        } else {
            System.out.println("Não há mais bolas para sortear.");
        }

    }

    public void reiniciarJogo() {
        bolasSorteadas.clear();
        bolasDisponiveis.clear();
        for (int bola = 1; bola <= 60; bola++) {
            bolasDisponiveis.add(bola);
        }
        System.out.println("Jogo do Bingo iniciado ou reiniciado.");
    }

    private static void imprimirMenu() {
        String[] menu = {
            "\n### MENU - JOGO DO BINGO ###",
            "1: Sortear bola",
            "2: Listar bolas sorteadas",
            "3: Reiniciar jogo",
            "0: Encerrar"
        };
        for (String item : menu) {
            System.out.println(item);
        }
        System.out.print("Digite a opção desejada: ");
    }

    public static void inicializar() {

        Bingo bingo = new Bingo();
        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        menu:
        while (true) {

            imprimirMenu();
            opcao = scanner.nextLine();
            System.out.println("");

            switch(opcao) {

                case ENCERRAR:
                    System.out.println("Jogo do Bingo encerrado.\n");
                    break menu;
                
                case SORTEAR:
                    bingo.sortearBola();
                    break;

                case LISTAR:
                    bingo.listarBolasSorteadas();
                    break;

                case REINICIAR:
                    bingo.reiniciarJogo();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;

            }

        }

        scanner.close();

    } 

}