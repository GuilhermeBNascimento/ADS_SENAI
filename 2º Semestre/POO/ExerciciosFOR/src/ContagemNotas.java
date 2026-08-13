import java.util.Scanner;

public class ContagemNotas {
    public static void main(String[] args) {
        int quantidade;
        int maiorIgualNove = 0;
        int faixaMedia = 0;
        int abaixo = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas notas quer ler: ");
        quantidade = scanner.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite a nota " + (i + 1) + ":");
            double nota = scanner.nextDouble();

            if (nota >= 9) {
                maiorIgualNove++;
            } else if (nota >=7) {
                faixaMedia++;
            } else {
                abaixo++;
            }
        }
        System.out.println("Notas maiores ou iguais a 9: " + maiorIgualNove);
        System.out.println("Notas de 7 até abaixo de 9: " + faixaMedia);
        System.out.println("Notas abaixo de 7: " + abaixo);
    }

}