import java.util.Scanner;

public class PositivoOuNegativo {
    public static void main(String[] args) {
        int positivo = 0;
        int negativo = 0;
        int quantidade;
        int num;
        int igualzero = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros quer ler: ");
        quantidade = scanner.nextInt();

        for(int i = 0; i < quantidade; i++) {
            System.out.print("Digite o numero " +(i + 1) + ":");
            num = scanner.nextInt();

            if (num > 0) {
                positivo++;
            }
            else if(num < 0) {
                negativo++;
            }
            else {
                igualzero++;
            }
        }
        System.out.println("Numeros positivos: " +positivo);
        System.out.println("Numeros negativos: " +negativo);
        System.out.println("Numeros iguais a zero: " +igualzero);
    }
}
