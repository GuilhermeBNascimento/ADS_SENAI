import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args) {
        int base;
        int multiplo = 0;
        int naomultiplo = 0;
        int qtdNumeros;
        int cont = 0;
        int NumDigitado;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero base: ");
        base = scanner.nextInt();
        if (base == 0) {
            System.out.println("Base nao pode ser zero!");
            scanner.close();
            return;
        }

        System.out.print("Numeros testados: ");
        qtdNumeros = scanner.nextInt();

        while (cont < qtdNumeros) {
            System.out.print("Digite o número " + (cont + 1) + ":");
            NumDigitado = scanner.nextInt();
            cont++;

            if (NumDigitado % base == 0) {
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