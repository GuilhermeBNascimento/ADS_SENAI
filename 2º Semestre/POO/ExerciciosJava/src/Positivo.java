import java.util.Scanner;

public class Positivo {
    public static void main(String[] args) {
        int positivo = 0;
        int negativo = 0;
        int quantidade;
        int cont = 0;
        int soma = 0;
        int media = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("quantos numeros vamos ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite o número " +(cont + 1) + ":");
            int num = scanner.nextInt();
            cont++;

            if (num > 0) {
                positivo++;
                soma+=num;
            }
            else {
                negativo++;
            }
        }
        System.out.println("Quantidade de positivos: " +positivo);
        System.out.println("A soma dos positivos: " +soma);

        if (positivo > 0) {
            media = soma / positivo;
            System.out.println("A media dos positivos: " + media);
        } else {
            System.out.println("Nenhum número positivo foi digitado.");
        }

    }
}
