import java.util.ArrayList;

public class Estudante {
    // atibuto sempre privete(por enquanto..)
    private String nome;
    private ArrayList<Double> notas;
    private double exame;

    public Estudante(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>();
    }
    // metodos sempre proted ou publico

    // nota exame - aprovado ou não

    //Getter e Setter

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addNota(double nota) {
        this.notas.add(nota);
    }

    protected double getSoma() {
        double soma = 0;
        int i = 0;
        while (i < this.notas.size()) {
            soma += this.notas.get(i);
            i++;
        }
        return soma;
    }

    public double getMedia() {
        return this.getSoma() / this.notas.size();
    }

    // Coloca a nota do exame
    public void setExame(double exame) {
        this.exame = exame;
    }

    // Retorna a nota do exame
    public double getExame() {
        return this.exame;
    }

    public double getMediaFinal() {
        return (this.getMedia() + this.exame) / 2;
    }

    // Verifica se foi aprovado
    public String getAprovado() {

        if (this.getMedia() >= 6) {
            return "Aprovado Direto";
        }
        if(this.getMediaFinal() >=6) {
            return "Aprovado após exame";
        }
        return "Reprovado";
    }
}