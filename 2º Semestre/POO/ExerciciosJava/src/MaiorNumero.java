import java.util.Scanner;

public class MaiorNumero {
    public static void main(String[] args) {
        int quantidade;
        int cont = 0;
        int maior = 0;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros você quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite o numero " + (cont + 1) + ":");
            num = scanner.nextInt();
            cont++;

            if (cont == 1) {
                maior = num;
            }
            else if (num > maior) {
                maior = num;
            }
        }
        System.out.println("Maior numero: " +maior);
    }
}
