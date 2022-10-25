import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Collections;

public class Agenda {
    
    private List<Contato> lista = new ArrayList<Contato>();

    public Contato getContato(int id) {
        try {
            return lista.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    public void imprimirMenu() {
        String[] menu = {
            "## MENU - AGENDA DE CONTATOS ##",
            "1: Inserir",
            "2: Listar",
            "3: Atualizar",
            "4: Apagar",
            "5: Pesquisar",
            "0: Encerrar"
        };
        for (String item : menu) {
            System.out.println(item);
        }
    } 

    public void inserir(Contato c) {
        lista.add(c);
        Collections.sort(lista); 
    }

    public void listar() {
        int id = 0;
        Iterator<Contato> i = lista.iterator();
        System.out.println("## LISTA DE CONTATOS ##");
        while (i.hasNext()) {
            System.out.println("ID: " + id++ + " - " + i.next());
        }
    }

    public void atualizar(int id, Contato c) {
        lista.set(id, c);
    }

    public void apagar(int id) {
        lista.remove(id);
    }

    public void pesquisar(String nome) {
        int id = 0;
        Iterator<Contato> i = lista.iterator();
        System.out.println("## RESULTADO ##");
        while (i.hasNext()) {
            id++;
            Contato c = i.next();
            if (c.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.println("ID: " + id + " - " + c);
            }
        }
    }

    public static void inicializar() {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        String id;
        String nome;
        String telefone;
        String email;
        Contato contato;
        String opcao;
        menu:
        while (true) {
            System.out.println("");
            agenda.imprimirMenu();
            System.out.print("Digite uma opção: ");
            opcao = scanner.nextLine();
            switch (opcao) {
                case "0": // Encerrar
                    break menu;
                case "1": // Inserir
                    System.out.print("Digite o Nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite o Telefone: ");
                    telefone = scanner.nextLine();
                    System.out.print("Digite o E-mail: ");
                    email = scanner.nextLine();
                    contato = new Contato(nome, telefone, email);
                    agenda.inserir(contato);
                    System.out.println("Contato inserido com sucesso!");
                    break;
                case "2": // Listar
                    agenda.listar();
                    break;
                case "3": // Atualizar
                    System.out.print("Digite o ID: ");
                    id = scanner.nextLine();
                    try {
                        Integer.parseInt(id);
                    } catch (Exception e) {
                        System.out.println("Valor inválido para o ID!");
                        break;
                    }
                    contato = agenda.getContato(Integer.parseInt(id));
                    if (contato == null) {
                        System.out.println("Contato não localizado!");
                        break;
                    }
                    System.out.println("ID: " + id + " - " + contato + "\n");
                    System.out.print("Deseja atualizar o Nome? (S/N) ");    
                    opcao = scanner.nextLine();
                    if (opcao.toUpperCase().equals("S")) {
                        System.out.print("Digite o Nome: ");
                        nome = scanner.nextLine();
                        contato.setNome(nome);
                    } 
                    System.out.print("Deseja atualizar o Telefone? (S/N) ");    
                    opcao = scanner.nextLine();
                    if (opcao.toUpperCase().equals("S")) {
                        System.out.print("Digite o Telefone: ");
                        telefone = scanner.nextLine();
                        contato.setTelefone(telefone);
                    }
                    System.out.print("Deseja atualizar o E-mail? (S/N) ");    
                    opcao = scanner.nextLine();
                    if (opcao.toUpperCase().equals("S")) {
                        System.out.print("Digite o E-mail: ");
                        email = scanner.nextLine();
                        contato.setEmail(email);
                    }
                    agenda.atualizar(Integer.parseInt(id), contato);
                    System.out.println("Contato atualizado com sucesso!");
                    break;
                case "4": // Apagar
                    System.out.print("Digite o ID: ");
                    id = scanner.nextLine();
                    try {
                        Integer.parseInt(id);
                    } catch (Exception e) {
                        System.out.println("Valor inválido para o ID!");
                        break;
                    }
                    contato = agenda.getContato(Integer.parseInt(id));
                    if (contato == null) {
                        System.out.println("Contato não localizado!");
                        break;
                    }
                    System.out.println("ID: " + id + " - " + contato);
                    agenda.apagar(Integer.parseInt(id));
                    System.out.println("Contato apagado com sucesso!");
                    break;
                case "5": // Pesquisar 
                    System.out.print("Digite o Nome: ");
                    nome = scanner.nextLine();
                    agenda.pesquisar(nome);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

}
