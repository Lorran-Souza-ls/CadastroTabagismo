import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        boolean continuar = true;

        while (continuar) {
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Listar Pessoas Cadastradas");
            System.out.println("3. Exportar Dados para CSV");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    
                    System.out.print("Digite a idade: ");
                    int idade = scanner.nextInt();
                    
                    System.out.print("Digite o gênero: ");
                    scanner.nextLine();  // Consumir nova linha
                    String genero = scanner.nextLine();
                    
                    System.out.print("A pessoa fuma? (True/False): ");
                    boolean fuma = scanner.nextBoolean();
                    
                    Pessoa pessoa = new Pessoa(nome, idade, genero, fuma);
                    cadastro.adicionarPessoa(pessoa);
                    System.out.println("Pessoa cadastrada com sucesso.");
                    break;
                    
                case 2:
                    cadastro.listarPessoas();
                    break;

                case 3:
                    System.out.print("Digite o caminho para exportar o CSV (ex: pessoas.csv): ");
                    String caminhoArquivo = scanner.nextLine();
                    cadastro.exportarParaCSV(caminhoArquivo);
                    break;
                    
                case 4:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        
        scanner.close();
    }
}
