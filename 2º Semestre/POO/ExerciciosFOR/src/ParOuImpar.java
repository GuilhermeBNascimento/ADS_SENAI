import java.util.Scanner;
import java.util.Random;

public class ParOuImpar {
    public static void main(String[] args) {
        int partidas;
        int numjogador;
        int vitoriasJogador = 0;
        int vitoriasComputador = 0;
        char opComputador;
        int soma;
        String vitoriaGeral;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Quantas partidas quer jogar: ");
        partidas = scanner.nextInt();

        for (int i = 0; i < partidas; i++) {
            char opcao = ' ';
            opComputador = ' ';

            for (;;) {
                System.out.println("--------------------");
                System.out.println("PARTIDA " + (i + 1));
                System.out.print("Digite sua escolha: ");
                opcao = scanner.next().charAt(0);

                if (opcao == 'P' || opcao == 'p') {
                    opComputador = 'I';
                    break;
                } else if (opcao == 'I' || opcao == 'i') {
                    opComputador = 'P';
                    break;
                } else {
                    System.out.println("Caracter invalido!");
                }
            }

            System.out.println("Computador escolheu: " + opComputador);

            System.out.print("Digite um numero: ");
            numjogador = scanner.nextInt();

            int numeroPC = random.nextInt(11);

            System.out.println("Computador jogou: " + numeroPC);

            soma = numjogador + numeroPC;

            System.out.println("Soma: " + soma);

            if (soma % 2 == 0) {
                System.out.println("Deu par");
                if (opcao == 'P' || opcao == 'p') {
                    System.out.println("Você venceu!");
                    vitoriasJogador++;
                } else {
                    System.out.println("Computador venceu!");
                    vitoriasComputador++;
                }
            } else {
                System.out.println("Deu impar");
                if (opcao == 'I' || opcao == 'i') {
                    System.out.println("Você venceu!");
                    vitoriasJogador++;
                } else {
                    System.out.println("Computador venceu!");
                    vitoriasComputador++;
                }
            }
        }

        if (vitoriasJogador > vitoriasComputador) {
            vitoriaGeral = "JOGADOR";
        } else if (vitoriasJogador == vitoriasComputador) {
            vitoriaGeral = "EMPATE";
        } else {
            vitoriaGeral = "COMPUTADOR";
        }

        System.out.println("--------------------");
        System.out.println("Vitórias do jogador: " + vitoriasJogador);
        System.out.println("Vitórias do computador: " + vitoriasComputador);
        System.out.println("Vencedor Geral: " + vitoriaGeral);

        scanner.close();
    }
}