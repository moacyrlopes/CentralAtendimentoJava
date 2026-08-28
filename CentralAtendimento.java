import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class CentralAtendimento {

    // Fila de clientes aguardando atendimento (FIFO)
    static Queue<String> clientes = new ArrayDeque<>();

    // Fila circular de guichês (o guichê usado volta para o final)
    static Queue<Integer> guiches = new ArrayDeque<>();

    // Pilha de histórico de atendimentos (LIFO) - usada com push/pop
    static Deque<String> historico = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        guiches.offer(1);
        guiches.offer(2);
        guiches.offer(3);

        int opcao;

        do {
            System.out.println("\n=========== CENTRAL DE ATENDIMENTO ===========");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Atender próximo cliente");
            System.out.println("3 - Mostrar fila");
            System.out.println("4 - Mostrar próximo guichê");
            System.out.println("5 - Desfazer última operação");
            System.out.println("6 - Mostrar histórico");
            System.out.println("0 - Encerrar");
            System.out.print("Escolha: ");

            // Leitura protegida: se o usuário digitar algo que não é número,
            // evita que o programa quebre com uma exceção não tratada.
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Opção inválida. Digite um número.");
                scanner.next();
                opcao = -1;
            }
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarCliente(scanner);
                    break;
                case 2:
                    atenderCliente();
                    break;
                case 3:
                    mostrarFila();
                    break;
                case 4:
                    mostrarProximoGuiche();
                    break;
                case 5:
                    desfazerOperacao();
                    break;
                case 6:
                    mostrarHistorico();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    if (opcao != -1) {
                        System.out.println("Opção inválida.");
                    }
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Requisito 1: adicionar cliente à fila (FIFO)
    static void adicionarCliente(Scanner scanner) {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        clientes.offer(nome);
        System.out.println(nome + " adicionada à fila.");
    }

    // Requisito 2 + 3 + 4: atender o próximo cliente
    // remove da fila, usa o guichê da vez, registra no histórico (pilha)
    // e devolve o guichê ao final da fila circular
    static void atenderCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Não existem clientes aguardando atendimento.");
            return;
        }

        String cliente = clientes.poll();       // remove o primeiro cliente (FIFO)
        Integer guiche = guiches.poll();         // pega o guichê da vez

        System.out.println("Cliente atendido: " + cliente);
        System.out.println("Guichê responsável: " + guiche);

        String registro = cliente + " - Guichê " + guiche;
        historico.push(registro);                // empilha no histórico (LIFO)

        guiches.offer(guiche);                   // devolve o guichê ao final (fila circular)
    }

    // Requisito 1: mostrar a fila de clientes na ordem de espera
    static void mostrarFila() {
        if (clientes.isEmpty()) {
            System.out.println("A fila de clientes está vazia.");
            return;
        }
        System.out.println("Fila de clientes:");
        for (String cliente : clientes) {
            System.out.println("- " + cliente);
        }
    }

    // Requisito 3: mostrar qual será o próximo guichê a atender,
    // sem removê-lo da fila circular
    static void mostrarProximoGuiche() {
        if (guiches.isEmpty()) {
            System.out.println("Nenhum guichê disponível.");
            return;
        }
        System.out.println("Próximo guichê: " + guiches.peek());
    }

    // Requisito 4: desfazer a última operação (retira o topo da pilha)
    static void desfazerOperacao() {
        if (historico.isEmpty()) {
            System.out.println("Não há operações no histórico para desfazer.");
            return;
        }
        String ultima = historico.pop();
        System.out.println("Operação desfeita: " + ultima);
    }

    // Requisito 4: mostrar o histórico, do topo (mais recente) para a base
    static void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("O histórico está vazio.");
            return;
        }
        System.out.println("Histórico de atendimentos (do mais recente para o mais antigo):");
        for (String registro : historico) {
            System.out.println("- " + registro);
        }
    }
}