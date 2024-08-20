// Cadastro.java
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private List<Pessoa> pessoas;

    // Construtor
    public Cadastro() {
        pessoas = new ArrayList<>();
    }

    // Adicionar pessoa ao cadastro
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    // Listar todas as pessoas cadastradas
    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }
    }
}
