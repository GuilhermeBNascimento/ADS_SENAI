import java.util.Scanner;

public class Intervalo {
    public static void main(String[] args) {
        int cont = 0;
        int quantidade;
        int interI = 0;
        int interF = 0;
        int intervalo = 0;
        int naointer = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o inicio do intervalo: ");
        interI = scanner.nextInt();
        System.out.print("Digite o fim do intervalo: ");
        interF = scanner.nextInt();

        if (interI > interF) {
            System.out.println("O início do intervalo não pode ser maior que o fim.");
            scanner.close();
            return;
        }
        System.out.print("Quantos Números: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite o número " +(cont + 1) + ":");
            int num = scanner.nextInt();
            cont++;

            if (num >=interI && num<=interF) {
                intervalo++;
            }
            else {
                naointer++;
            }
        }
        System.out.println("Esta no intervalo: " +intervalo);
        System.out.println("Não esta no intervalo: " +naointer);
    }

}
