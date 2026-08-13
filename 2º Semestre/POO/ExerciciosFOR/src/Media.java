import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        int qtd;
        double nota;
        double soma = 0;
        double media;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos notas quer ler: ");
        qtd = scanner.nextInt();

        for (int i = 0; i < qtd; i++) {
            System.out.print("Digite a nota " +(i + 1) + ":");
            nota = scanner.nextDouble();
            soma+=nota;

        }
        media = soma / qtd;
        System.out.println("Media da turma: " +media);
    }
}
