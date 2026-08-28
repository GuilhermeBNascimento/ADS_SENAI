import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o num1: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o num2: ");
        double num2 = scanner.nextDouble();

        System.out.print("Digite a operação (+ - * /): ");
        char operador = scanner.next().charAt(0);

        double resultado = calcular2(num1, num2, operador);
        System.out.println("Resultado: " +resultado);

        scanner.close();
    }

    public static double soma(double a, double b) {
        return a + b;
    }

    public static double subtracao(double a, double b) {
        return a - b;
    }

    public static double multiplicacao(double a, double b) {
        return a * b;
    }

    public static double divisao(double a, double b) {
        if (b == 0) {
            System.out.println("Impossivel dividir por zero!");
            return 0;
        }
        else {
            return a / b;
        }

    }

    public static double calcular(double a, double b, char operador) {
        double resultado = 0;

        switch (operador) {
            case '+':
                resultado = soma(a,b);
                break;
            case '-':
                resultado = subtracao(a,b);
                break;
            default:
                System.out.println("Operador invalido");
        }
        return resultado;
    }

    public static double calcular2(double a, double b, char operador) {
        return switch (operador) {
            case '+' -> soma(a,b);
            case '-' -> subtracao(a,b);
            case '*' -> multiplicacao(a,b);
            case '/' -> divisao(a,b);
            default -> {
                System.out.println("Operador invalido");
                yield 0;
            }
        };
    }


}
