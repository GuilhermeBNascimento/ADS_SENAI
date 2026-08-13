import java.util.Scanner;

public class ParesMaiorDez {
    public static void main(String[] args) {
        int qtd;
        int par = 0;
        int impar = 0;
        int maiorquedez = 0;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros quer ler: ");
        qtd = scanner.nextInt();

        for (int i = 0; i < qtd; i++) {
            System.out.print("Digite o numero " +(i + 1) + ":");
            num = scanner.nextInt();

            if(num % 2 == 0) {
                par++;
            }
            else {
                impar++;
            }
            if(num > 10) {
                maiorquedez++;
            }
        }
        System.out.println("Números pares: " +par);
        System.out.println("Números impares: " +impar);
        System.out.println("Números maiores que dez: " +maiorquedez);
    }
}
