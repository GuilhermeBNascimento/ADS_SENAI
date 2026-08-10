import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        int cont = 0;
        int par = 0;
        int impar = 0;
        int positivo = 0;
        int negativo = 0;
        int maior = 0;
        int menor = 0;
        int soma = 0;
        int media;
        int quantidade;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros quer ler: ");
        quantidade = scanner.nextInt();

        while (cont < quantidade) {
            System.out.print("Digite o numero: " +(cont + 1) + ":");
            int num = scanner.nextInt();
            cont++;
            soma+=num;

            if (num % 2 == 0) {
                par++;
            }
            else {
                impar++;
            }
             if(num > 0) {
                positivo++;
            }
            else if(num < 0) {
                negativo++;
            }

            if (cont == 1) {
                maior = num;
                menor = num;
            }
            else if(num > maior) {
                maior = num;
            }
            else if (num < menor) {
                menor = num;
            }
        }
        media = soma / quantidade;
        System.out.println("Numeros pares: " +par);
        System.out.println("Numeros impares: " +impar);
        System.out.println("Numeros positivos: " +positivo);
        System.out.println("Numeros negativos: " +negativo);
        System.out.println("Maior numero: " +maior);
        System.out.println("Menor numero: " +menor);
        System.out.println("Soma dos numeros: " +soma);
        System.out.println("A media dos numeros: " +media);
    }
}
