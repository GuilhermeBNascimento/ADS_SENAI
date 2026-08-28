import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numero_escolhido = gerarNumeroAleatorio();
        int cont = 0;

        for (;;) {
            System.out.println("Digite seu palpite: ");
            int palpite = scanner.nextInt();

            cont++;

            if (palpite == numero_escolhido) {
                System.out.println("Parabéns, você acertou!");
                System.out.println("Você precisou de " + cont + " tentativas.");
                break;

            } else if (palpite < numero_escolhido) {
                System.out.println("Você está frio. Tente um número maior.");

            } else {
                System.out.println("Está quente. Tente um número menor.");
            }
        }

        scanner.close();
    }

    public static int gerarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
