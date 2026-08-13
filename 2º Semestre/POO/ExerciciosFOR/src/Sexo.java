import java.util.Scanner;

public class Sexo {
    public static void main(String[] args) {
        char sexo;
        int masc = 0;
        int fem = 0;
        int qtd;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas pessoas você quer ler: ");
        qtd = scanner.nextInt();

        for (int i = 0; i<qtd; i++) {
            for(;;) {
                System.out.print("Digite seu sexo: ");
                sexo = scanner.next().charAt(0);

                if (sexo == 'm' || sexo == 'M') {
                    masc++;
                    break;
                } else if (sexo == 'f' || sexo == 'F') {
                    fem++;
                    break;
                } else {
                    System.out.println("Caracter invalido");

                }
            }
        }
        System.out.println("Homens: " +masc);
        System.out.println("Mulheres: " +fem);
    }
}
