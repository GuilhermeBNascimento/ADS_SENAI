import java.util.Scanner;

public class Aprovacao {
    public static void main(String[] args) {
        int quantidade;
        int aprovado = 0;
        int reprovado = 0;
        double nota;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas notas quer ler: ");
        quantidade = scanner.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite a nota " +(i + 1) + ":");
            nota = scanner.nextDouble();

            if(nota>=7) {
                aprovado++;
            }
            else {
                reprovado++;
            }
        }
        System.out.println("Aprovados: " +aprovado);
        System.out.println("Reprovados: " +reprovado);
    }
}
