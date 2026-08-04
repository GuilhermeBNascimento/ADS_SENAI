import java.util.Scanner;

public class SomaPares {
    public static void main(String[] args) {
        int quantidade;
        int cont = 0;
        int somapar = 0;
        int somaimpar = 0;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros você quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite o numero " + (cont + 1) + ":");
            num = scanner.nextInt();
            cont++;

            if (num % 2 == 0) {
                somapar+=num;
            }
            else {
                somaimpar+=num;
            }
        }
        System.out.println("Soma números pares: " +somapar);
        System.out.println("Soma números impares: " +somaimpar);
    }
}
