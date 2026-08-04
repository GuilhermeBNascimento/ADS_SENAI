import java.util.Scanner;

public class MaiorIdade {
    public static void main(String[] args) {
        int quantidade;
        int cont = 0;
        int maioridade = 0;
        int menoridade = 0;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos idades você quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite a idade " + (cont + 1) + ":");
            num = scanner.nextInt();
            cont++;

            if (num >= 18) {
                maioridade++;
            }
            else {
                menoridade++;
            }
        }
        System.out.println("Maiores de idade: " +maioridade);
        System.out.println("Menores de idade: " +menoridade);
    }
}

