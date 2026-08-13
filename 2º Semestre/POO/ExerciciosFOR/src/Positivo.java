import java.util.Scanner;

public class Positivo {
    public static void main(String[] args) {
        int positivo = 0;
        int quantidade;
        double soma = 0;
        double media = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("quantos numeros vamos ler: ");
        quantidade = scanner.nextInt();

        for (int i = 0; i<quantidade; i++) {
            System.out.print("Digite o número " +(i + 1) + ":");
            int num = scanner.nextInt();

            if (num > 0) {
                positivo++;
                soma+=num;
            }

        }

        if (positivo > 0) {
            media = soma / positivo;
            System.out.println("A media dos positivos: " + media);
        } else {
            System.out.println("Nenhum número positivo foi digitado.");
        }
        System.out.println("Quantidade de positivos: " +positivo);
        System.out.println("A soma dos positivos: " +soma);

    }
}
