import java.util.Scanner;

public class despesas {
    public static void main(String[] args) {

        double soma = 0;
        double maior = 0;
        double menor = 0;
        int qtd = 0;

        Scanner scanner = new Scanner(System.in);

        String entrada;

        do {
            System.out.print("Digite uma despesa (ENTER para finalizar): ");
            entrada = scanner.nextLine().trim();

            if (!entrada.isEmpty()) {

                double valor = Double.parseDouble(entrada.replace(',', '.'));

                soma += valor;
                qtd++;

                if (qtd == 1) {
                    maior = valor;
                    menor = valor;
                }

                if(valor > maior) {
                    maior = valor;
                }
                else if(valor < menor) {
                    menor = valor;
                }
            }

        } while (!entrada.isEmpty());

        if (qtd > 0) {
            double media = soma / qtd;

            System.out.printf("%nMaior gasto: %.2f%n", maior);
            System.out.printf("Menor gasto: %.2f%n", menor);
            System.out.printf("Soma dos gastos: %.2f%n", soma);
            System.out.printf("Média dos gastos: %.2f%n", media);
        } else {
            System.out.println("Nenhuma despesa informada.");
        }

        scanner.close();
    }
}