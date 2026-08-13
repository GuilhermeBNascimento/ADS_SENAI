import java.util.Scanner;

public class Senha {
    public static void main(String[] args) {
        int senhaC = 1234;
        int senhaD;
        int max;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de tentativas: ");
        max = scanner.nextInt();

        if(max <=0) {
            System.out.println("Erro!, digite um numero maior que zero e que nao seja negativo");
            scanner.close();
            return;
        }

        int tentativas = max;

        for (int i = 0; i < max; i++) {
            System.out.print("Digite sua senha: ");
            senhaD = scanner.nextInt();

            if(senhaD == senhaC) {
                System.out.println("Logado com sucesso!");
                break;
            }
            else {
                tentativas = max - i - 1;
                System.out.println("Senha incorreta!");
                System.out.println("Tentativas restantes: " +tentativas);
            }
        }
        if(tentativas == 0) {
            System.out.println("Conta bloqueada!");
        }
    }
}
