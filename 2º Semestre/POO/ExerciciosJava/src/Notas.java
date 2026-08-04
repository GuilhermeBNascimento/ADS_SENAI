import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        int quantidade;
        int cont = 0;
        double nota;
        int aprovado = 0;
        int reprovado = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas notas você quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite a nota " + (cont + 1) + ":");
            nota = scanner.nextDouble();
            cont++;

            if (nota >= 7) {
                aprovado++;
            }
            else {
                reprovado++;
            }
        }
        System.out.println("Alunos aprovados: " +aprovado);
        System.out.println("Alunos reprovados: " +reprovado);
    }
}

