import java.util.Scanner;

public class Sexo {
    public static void main(String[] args) {
        char sexo;
        int cont = 0;
        int masc = 0;
        int fem = 0;
        int quantidade;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas pessoas você quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite seu sexo: ");
            sexo = scanner.next().charAt(0);

            if (sexo == 'm' || sexo == 'M') {
                masc++;
                cont++;
            }
            else if(sexo == 'f' || sexo == 'F') {
                fem++;
                cont++;
            }
            else {
                System.out.println("Caracter invalido");
            }
        }
        System.out.println("Homens: " +masc);
        System.out.println("Mulheres: " +fem);
    }
}
