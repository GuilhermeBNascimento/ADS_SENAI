import java.util.Scanner;

public class MaiorIdade {
    public static void main(String[] args) {
        int quantidade;
        int idade;
        int maioridade = 0;
        int menoridade = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas idades quer ler: ");
        quantidade = scanner.nextInt();

        for(int i = 0; i < quantidade; i++) {
            System.out.print("Digite a idade " +(i + 1) + ":");
            idade = scanner.nextInt();

            if(idade >=18) {
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
