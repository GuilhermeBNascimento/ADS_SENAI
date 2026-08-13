import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args) {
        int base;
        int multiplo = 0;
        int naomultiplo = 0;
        int qtd;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero base: ");
        base = scanner.nextInt();
        if (base == 0) {
            System.out.println("Base nao pode ser zero!");
            scanner.close();
            return;
        }

        System.out.print("Numeros testados: ");
        qtd = scanner.nextInt();

        for (int i = 0; i<qtd; i++) {
            System.out.print("Digite o número " + (i + 1) + ":");
            num = scanner.nextInt();

            if (num % base == 0) {
                multiplo++;
            }
            else {
                naomultiplo++;
            }

        }
        System.out.println("Quantidade de números múltiplos de " + base + ": " + multiplo);
        System.out.println("Quantidade de números NÃO múltiplos de " + base + ": " + naomultiplo);

    }
}
