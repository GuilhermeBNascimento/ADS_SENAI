import java.util.Scanner;

public class MaiorQueDez {
    public static void main(String[] args) {
        int quantidade;
        int cont = 0;
        int par = 0;
        int impar = 0;
        int maiordez = 0;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros você quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite o numero " + (cont + 1) + ":");
            num = scanner.nextInt();
            cont++;

            if (num % 2 == 0) {
                par++;
            }
            else {
                impar++;
            }
            if (num > 10) {
                maiordez++;
            }
        }
        System.out.println("Números pares: " +par);
        System.out.println("Números impares: " +impar);
        System.out.println("Números maiores que dez: " +maiordez);
    }
}