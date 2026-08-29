import java.util.ArrayList;

public class Estudante {
    // atibuto sempre privete(por enquanto..)
    private String nome;
    private ArrayList<Double> notas;
    private double exame;
    private String aprovado;

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

    public void addExame(double exame) {
        this.notas.add(exame);
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

    public String getAprovado() {
        if (this.getMedia() >= 6) {
             this.aprovado = "APROVADO";
        }
        else if(this.getMedia() < 6) {
            System.out.println("Esta em exame");
            if (this.g)
        }
        else {
             this.aprovado = "REPROVADO";
        }
        return this.aprovado;
    }
}