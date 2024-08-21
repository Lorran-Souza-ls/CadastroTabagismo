// Código da classe Pessoa
public class Pessoa {
    private String nome;
    private int idade;
    private String genero;
    private boolean fuma;

    public Pessoa(String nome, int idade, String genero, boolean fuma) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.fuma = fuma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Gênero: " + genero + ", Fuma: " + (fuma ? "Sim" : "Não");
    }
}