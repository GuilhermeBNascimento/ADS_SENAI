import java.util.Scanner;

public class SomaTotal {
    public static void main(String[] args) {
        int soma = 0;
        int media = 0;
        int quantidade;
        int cont = 0;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros voce quer: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite o número " + (cont + 1) + ":");
            num = scanner.nextInt();
            cont++;
            soma+=num;

        }
        media = soma / quantidade;
        System.out.println("A soma dos números: " +soma);
        System.out.println("A média dos números: " +media);

    }
}
