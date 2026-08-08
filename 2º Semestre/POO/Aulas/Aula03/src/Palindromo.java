public class Palindromo {
    public static void main(String[] args) {
        String palavra = "Banana";
        char[] arrayPalavra = palavra.toCharArray();

        int tamanho = arrayPalavra.length;

        char[] arrzyInvertido = new char[tamanho];

        for (int i = 0; i < tamanho; i++) {
            arrzyInvertido[tamanho - i - 1] = arrayPalavra[i];
        }
        // comparação
        boolean ehPalindromo = true;
        for (int i = 0; i < tamanho; i++) {
            if (arrzyInvertido[i] != arrayPalavra[i]) {
                ehPalindromo = false;
                break;
            }

        }
        if (ehPalindromo) {
            System.out.println("È palindromo");
        }
        else {
            System.out.println("Não é palindromo");
        }
    }
}







