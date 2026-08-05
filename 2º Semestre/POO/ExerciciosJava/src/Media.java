import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        int quantidade;
        int cont = 0;
        double soma = 0;
        double nota;
        double media = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros você quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite a nota" + (cont + 1) + ":");
            nota = scanner.nextDouble();
            cont++;
            soma+=nota;
        }
        media = soma / quantidade;
        System.out.printf("A média da turma é: %.1f", media);
    }
}
