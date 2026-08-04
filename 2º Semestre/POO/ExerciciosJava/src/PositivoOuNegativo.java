import java.util.Scanner;

public class PositivoOuNegativo {
    public static void main(String[] args) {
        int quantidade;
        int cont = 0;
        int positivo = 0;
        int negativo = 0;
        int igualzero = 0;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros você quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite o numero " + (cont + 1) + ":");
            num = scanner.nextInt();
            cont++;

            if (num > 0) {
                positivo++;
            }
            else if (num < 0) {
                negativo++;
            }
            else {
                igualzero++;
            }
        }
        System.out.println("Números positivos: " +positivo);
        System.out.println("Números negativos: " +negativo);
        System.out.println("Números iguais a zero: " +igualzero);
    }
}
