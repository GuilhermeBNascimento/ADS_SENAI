import java.util.Scanner;

public class SomaPares {
    public static void main(String[] args) {
        int qtd;
        int num;
        int somapar = 0;
        int somaimpar = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros quer ler: ");
        qtd = scanner.nextInt();

        for (int i = 0; i < qtd; i++) {
            System.out.print("Digite o numero " +(i + 1) + ":");
            num = scanner.nextInt();

            if(num % 2 == 0) {
                somapar+=num;
            }
            else {
                somaimpar+=num;
            }
        }
        System.out.println("Soma dos números pares: " +somapar);
        System.out.println("Soma dos números impares: " +somaimpar);
    }
}
