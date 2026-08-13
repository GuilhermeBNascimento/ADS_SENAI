import java.util.Scanner;

public class MenorNumero {
    public static void main(String[] args) {
        int qtd;
        int num;
        int menor = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros quer ler: ");
        qtd = scanner.nextInt();

        for (int i = 0; i < qtd; i++) {
            System.out.print("Digite o numero " +(i + 1) + ":");
            num = scanner.nextInt();

            if (i == 0) {
                menor = num;
            }

            if(num < menor) {
                menor = num;
            }
        }
        System.out.println("Maior numero: " +menor);
    }
}
