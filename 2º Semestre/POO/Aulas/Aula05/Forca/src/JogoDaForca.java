import java.util.Arrays;
import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Jogador 1 informa a palavra secreta
        System.out.print("Jogador 1, digite a palavra secreta: ");
        String palavra = scanner.nextLine().toLowerCase();

        // Limpa a tela para esconder a palavra do Jogador 2
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        // Array que representa a palavra oculta
        char[] palavraOculta = new char[palavra.length()];
        Arrays.fill(palavraOculta, '_');

        int erros = 0;
        final int MAX_ERROS = 5;

        // Guarda as letras que já foram tentadas
        String letrasTentadas = "";

        System.out.println("=================================");
        System.out.println("        JOGO DA FORCA");
        System.out.println("=================================");

        while (erros < MAX_ERROS) {

            // Exibe a palavra parcialmente descoberta
            System.out.print("\nPalavra: ");
            for (char letra : palavraOculta) {
                System.out.print(letra + " ");
            }

            System.out.println("\nErros: " + erros + "/" + MAX_ERROS);

            // Verifica se a palavra já foi descoberta
            if (String.valueOf(palavraOculta).equals(palavra)) {
                System.out.println("\n=================================");
                System.out.println("       PARABÉNS! VOCÊ VENCEU!");
                System.out.println("Palavra: " + palavra);
                System.out.println("=================================");
                scanner.close();
                return;
            }

            System.out.print("Digite uma letra: ");
            String entrada = scanner.nextLine().toLowerCase();

            // Validação da entrada
            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("Digite apenas uma letra.");
                continue;
            }

            char letra = entrada.charAt(0);

            // Verifica se a letra já foi tentada
            if (letrasTentadas.indexOf(letra) != -1) {
                System.out.println("Você já tentou essa letra!");
                continue;
            }

            letrasTentadas += letra;

            boolean acertou = false;

            // Procura a letra na palavra
            for (int i = 0; i < palavra.length(); i++) {

                if (palavra.charAt(i) == letra) {
                    palavraOculta[i] = letra;
                    acertou = true;
                }
            }

            if (acertou) {
                System.out.println("Boa! A letra '" + letra + "' está na palavra.");
            } else {
                erros++;
                System.out.println("Ops! A letra '" + letra + "' não está na palavra.");
            }
        }

        // Caso o jogador atinja o limite de erros
        System.out.println("\n=================================");
        System.out.println("          VOCÊ PERDEU!");
        System.out.println("=================================");
        System.out.println("A palavra secreta era: " + palavra);

        scanner.close();
    }
}