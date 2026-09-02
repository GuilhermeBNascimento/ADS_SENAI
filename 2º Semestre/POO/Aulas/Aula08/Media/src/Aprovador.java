import java.util.ArrayList;

public class Aprovador {
    public static void main(String[] args) {
        Estudante pedro = new Estudante("Pedro");
        pedro.addNota(9.0);
        pedro.addNota(9.0);
        pedro.addNota(9.0);

        Estudante maria = new Estudante("Maria");
        maria.addNota(5.0);
        maria.addNota(5.0);
        maria.addNota(6.0);
        maria.setExame(8.0);

        Estudante joao = new Estudante("João");
        joao.addNota(3.0);
        joao.addNota(4.0);
        joao.addNota(2.0);
        joao.setExame(4.0);

        //Estudante[] estudantes = new Estudante[] { pedro, maria };
        ArrayList<Estudante> estudantes = new ArrayList<>();
        estudantes.add(pedro);
        estudantes.add(maria);
        estudantes.add(joao);

        System.out.println("=== RESULTADO DOS ESTUDANTES ===");

        for (Estudante estudante: estudantes) {
            System.out.println();
            System.out.println("Aluno: " + estudante.getNome());
            System.out.println("Média: " + estudante.getMedia());

            if (estudante.getMedia() >= 6) {

                System.out.println("Situação: Aprovado direto");

            } else {

                System.out.println("Situação: Exame");
                System.out.println("Nota do exame: " + estudante.getExame());
                System.out.println("Média final: " + estudante.getMediaFinal());
                System.out.println("Resultado: " + estudante.getAprovado());
            }
        }

    }
}