import java.util.Scanner;

public class SomaTotal {
    public static void main(String[] args) {
        int soma = 0;
        int qtd;
        int num;
        int media;

        Scanner scanner = new Scanner(System.in);


        System.out.print("Quantos numeros quer ler: ");
        qtd = scanner.nextInt();

        for (int i = 0; i<qtd; i++) {
            System.out.print("Digite o número " + (i + 1) + ":");
            num = scanner.nextInt();
            soma+=num;

        }
        media = soma / qtd;
        System.out.println("Soma: " +soma);
        System.out.println("Media: " +media);

    }
}
