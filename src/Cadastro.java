import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private List<Pessoa> pessoas;

    public Cadastro() {
        pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }
    }

    public void exportarParaCSV(String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write("Nome,Idade,Genero,Fuma\n");
            for (Pessoa pessoa : pessoas) {
                writer.write(pessoa.getNome() + "," +
                             pessoa.getIdade() + "," +
                             pessoa.getGenero() + "," +
                             (pessoa.isFuma() ? "Sim" : "Não") + "\n");
            }
            System.out.println("Dados exportados para CSV com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao exportar para CSV: " + e.getMessage());
        }
    }

    public void importarDeCSV(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            reader.readLine(); // Ignorar cabeçalho
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    String nome = dados[0];
                    int idade = Integer.parseInt(dados[1]);
                    String genero = dados[2];
                    boolean fuma = dados[3].equalsIgnoreCase("Sim");
                    
                    Pessoa pessoa = new Pessoa(nome, idade, genero, fuma);
                    pessoas.add(pessoa);
                }
            }
            System.out.println("Dados importados do CSV com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao importar do CSV: " + e.getMessage());
        }
    }
}
