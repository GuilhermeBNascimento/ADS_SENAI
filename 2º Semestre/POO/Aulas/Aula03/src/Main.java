public class Main {
    public static void main(String[] args) {
        int acumula = 0;
        int []valores = new int[] {2,3,5,7,11};

        // ou por exemplo
        // int valores[] = new int[] {2,3,5,7,11};

        // ou ainda
        // int[] valores = new int[5];
        //valores[0] = 2;
        //valores[1] = 3;

        for (int i = 0; i < valores.length; i++) {
            acumula+=valores[i];
            System.out.println("Total acumulador: " +acumula);
        }
        System.out.println("Total acumulador: " +acumula);
        System.out.println("--------");

        acumula = 0;

        for (int valor: valores) {
            acumula+=valor;
            System.out.println("Total " +acumula);
        }
        System.out.println("Total acumulador: " +acumula);
    }
}