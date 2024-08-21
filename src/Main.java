import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        boolean continuar = true;

        do {
            mostrarMenu();
            int opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1:
                    cadastrarPessoa(scanner, cadastro);
                    break;
                    
                case 2:
                    cadastro.listarPessoas();
                    break;
                    
                case 3:
                    exportarDados(scanner, cadastro);
                    break;
                    
                case 4:
                    importarDados(scanner, cadastro);
                    break;
                    
                case 5:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (continuar);
        
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("1. Cadastrar Pessoa");
        System.out.println("2. Listar Pessoas Cadastradas");
        System.out.println("3. Exportar Dados para CSV");
        System.out.println("4. Importar Dados do CSV");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao(Scanner scanner) {
        int opcao = 0;
        boolean opcaoValida = false;
        while (!opcaoValida) {
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao < 1 || opcao > 5) {
                    throw new InputMismatchException();
                }
                opcaoValida = true;
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Digite um número entre 1 e 5: ");
                scanner.nextLine();
            }
        }
        return opcao;
    }

    private static void cadastrarPessoa(Scanner scanner, Cadastro cadastro) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        
        int idade = -1;
        while (idade < 0) {
            System.out.print("Digite a idade: ");
            try {
                idade = scanner.nextInt();
                if (idade < 0) {
                    System.out.println("A idade não pode ser negativa.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido para a idade.");
                scanner.nextLine();
            }
        }
        
        System.out.print("Digite o gênero: ");
        scanner.nextLine();
        String genero = scanner.nextLine();
        
        boolean fuma = false;
        boolean fumaValido = false;
        while (!fumaValido) {
            System.out.print("A pessoa fuma? (True/False): ");
            try {
                fuma = scanner.nextBoolean();
                fumaValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite 'True' ou 'False'.");
                scanner.nextLine();
            }
        }
        
        Pessoa pessoa = new Pessoa(nome, idade, genero, fuma);
        cadastro.adicionarPessoa(pessoa);
        System.out.println("Pessoa cadastrada com sucesso.");
    }

    private static void importarDados(Scanner scanner, Cadastro cadastro) {
        System.out.print("Digite o caminho do arquivo CSV para importar: ");
        String caminhoArquivo = scanner.nextLine();
        cadastro.importarDeCSV(caminhoArquivo);
    }
    
    private static void exportarDados(Scanner scanner, Cadastro cadastro) {
        System.out.print("Digite o caminho do arquivo CSV para exportar: ");
        String caminhoArquivo = scanner.nextLine();
        cadastro.exportarParaCSV(caminhoArquivo);
    }
}
