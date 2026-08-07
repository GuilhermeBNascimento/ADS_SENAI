import java.util.Scanner;

public class ComtagemNotas {
    public static void main(String[] args) {
        int quantidade;
        int cont = 0;
        int maiorigualnove = 0;
        int media = 0;
        int abaixo = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas notas quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite a nota " + (cont + 1) + ":");
            double nota = scanner.nextDouble();
            cont++;

            if (nota >= 9) {
                maiorigualnove++;
            } else if (nota >=7) {
                media++;
            } else {
                abaixo++;
            }
        }
        System.out.println("Notas maiores ou iguais a 9: " + maiorigualnove);
        System.out.println("Notas de 7 até abaixo de 9: " + media);
        System.out.println("Notas abaixo de 7: " + abaixo);
    }

    }

