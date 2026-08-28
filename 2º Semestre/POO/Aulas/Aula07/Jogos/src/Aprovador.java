import java.util.ArrayList;
import java.util.Scanner;

public class Aprovador {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Jogo> jogos = new ArrayList<>();

        System.out.print("Quantos jogos o time fez: ");
        int qtdJogos = scanner.nextInt();

        // Cadastro dos jogos
        for (int i = 0; i < qtdJogos; i++) {

            Jogo jogo = new Jogo();

            System.out.println("\nJogo " + (i + 1));

            System.out.print("Gols marcados: ");
            jogo.golsMarcados = scanner.nextInt();

            System.out.print("Gols sofridos: ");
            jogo.golsSofridos = scanner.nextInt();

            jogos.add(jogo);
        }

        // Variáveis para o resumo
        int vitorias = 0;
        int empates = 0;
        int derrotas = 0;
        int pontos = 0;
        int golsMarcados = 0;
        int golsSofridos = 0;

        // Processamento dos jogos
        for (Jogo jogo : jogos) {

            golsMarcados += jogo.golsMarcados;
            golsSofridos += jogo.golsSofridos;

            if (jogo.golsMarcados > jogo.golsSofridos) {

                vitorias++;
                pontos += 3;

            } else if (jogo.golsMarcados == jogo.golsSofridos) {

                empates++;
                pontos += 1;

            } else {

                derrotas++;
            }
        }

        // Cálculo do saldo de gols
        int saldoGols = golsMarcados - golsSofridos;

        // Cálculo dos pontos possíveis
        int pontosPossiveis = qtdJogos * 3;

        // Cálculo do aproveitamento
        double aproveitamento = (double) pontos / pontosPossiveis * 100;

        // Exibição do resultado
        System.out.println("\n=== RESUMO DA CAMPANHA ===");

        System.out.println("Vitórias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
        System.out.println("Gols marcados: " + golsMarcados);
        System.out.println("Gols sofridos: " + golsSofridos);
        System.out.println("Saldo de gols: " + saldoGols);
        System.out.println("Aproveitamento: " + aproveitamento + "%");

        scanner.close();
    }
}
