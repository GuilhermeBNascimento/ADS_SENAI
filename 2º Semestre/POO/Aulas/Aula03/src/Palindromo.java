import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        String palavra;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma palavra: ");
        palavra = scanner.nextLine();
        char[] arrayPalavra = palavra.toLowerCase().toCharArray();

        char[] arrayPalindromo = new char[arrayPalavra.length];

        // Criando a palavra invertida
        for (int i = 0; i < arrayPalavra.length; i++) {
            arrayPalindromo[i] = arrayPalavra[arrayPalavra.length - 1 - i];
        }

        // Mostrando a palavra original
        System.out.print("Original: ");
        for (int i = 0; i < arrayPalavra.length; i++) {
            System.out.print(arrayPalavra[i]);
        }

        System.out.println();

        // Mostrando a palavra invertida
        System.out.print("Invertido: ");
        for (int i = 0; i < arrayPalindromo.length; i++) {
            System.out.print(arrayPalindromo[i]);
        }

        System.out.println();

        // Verificando se é palíndromo
        boolean palindromo = true;

        for (int i = 0; i < arrayPalavra.length; i++) {
            if (arrayPalavra[i] != arrayPalindromo[i]) {
                palindromo = false;
                break;
            }
        }

        if (palindromo) {
            System.out.println("É palíndromo!");
        } else {
            System.out.println("Não é palíndromo!");
        }
    }
}







