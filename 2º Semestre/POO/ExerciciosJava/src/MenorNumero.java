import java.util.Scanner;

public class MenorNumero {
    public static void main(String[] args) {
        int quantidade;
        int cont = 0;
        int menor = 0;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros você quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite o numero " + (cont + 1) + ":");
            num = scanner.nextInt();
            cont++;

            if (cont == 1) {
                menor = num;
            }
            else if (num < menor) {
                menor = num;
            }
        }
        System.out.println("Menor numero: " +menor);
    }
}
