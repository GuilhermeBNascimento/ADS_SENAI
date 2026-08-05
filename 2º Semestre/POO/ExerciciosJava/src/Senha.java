import java.util.Scanner;

public class Senha {
    public static void main(String[] args) {
        int senha = 1234;
        int senhaDigitada;
        int cont = 0;
        int max;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Numeros de tentativas: ");
        max = scanner.nextInt();

        while (cont < max) {
            System.out.print("Digite a senha " + ":");
            senhaDigitada = scanner.nextInt();
            cont++;

            if (senhaDigitada == senha) {
                System.out.println("Acesso liberado");
                break;
            }
            else {
                System.out.println("Senha invalida!");
                System.out.println("Tentativas restantes: " + (max - cont));
            }

            if (cont == max) {
                System.out.println("Conta bloqueada!");
            }


        }

    }
}

