import java.util.ArrayList;

public class Aprovador {
    public static void main(String[] args) {
        Estudante pedro = new Estudante("Pedro");
        pedro.addNota(9.0);
        pedro.addNota(9.0);
        pedro.addNota(9.0);

        Estudante maria = new Estudante("Maria");
        maria.addNota(3);
        maria.addNota(5.0);
        maria.addNota(4);
        maria.setExame(10);

        //Estudante[] estudantes = new Estudante[] { pedro, maria };
        ArrayList<Estudante> estudantes = new ArrayList<>();
        estudantes.add(pedro);
        estudantes.add(maria);
        
        System.out.println("=== Calculo da Media ===");

        for (Estudante estudante: estudantes) {
            System.out.println("Media do estudante " + 
                estudante.getNome() + ":" + estudante.getMedia() + " "+ "Resultado: " + estudante.getAprovado());
        }

    }
}