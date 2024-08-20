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

    public int getIdade() {
        return idade;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isFuma() {
        return fuma;
    }

    @Override
    public String toString() {
        return nome + "," + idade + "," + genero + "," + (fuma ? "Sim" : "Não");
    }
}
