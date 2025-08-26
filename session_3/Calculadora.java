import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;  // variable para el menú
        double num1, num2, resultado;
        int continuar = 1; // 1 = seguir, 0 = salir

        while (continuar == 1) {
            System.out.println("===== CALCULADORA =====");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingresa el primer número: ");
                num1 = sc.nextDouble();
                System.out.print("Ingresa el segundo número: ");
                num2 = sc.nextDouble();

                if (opcion == 1) {
                    resultado = num1 + num2;
                    System.out.println("Resultado: " + resultado);
                } else if (opcion == 2) {
                    resultado = num1 - num2;
                    System.out.println("Resultado: " + resultado);
                } else if (opcion == 3) {
                    resultado = num1 * num2;
                    System.out.println("Resultado: " + resultado);
                } else if (opcion == 4) {
                    if (num2 != 0) {
                        resultado = num1 / num2;
                        System.out.println("Resultado: " + resultado);
                    } else {
                        System.out.println("Error: división por cero.");
                    }
                }
            } else if (opcion == 5) {
                continuar = 0;
            } else {
                System.out.println("Opción no válida.");
            }

            // Pequeño ciclo For para mostrar una línea separadora
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println();
        }

        System.out.println("¡Gracias por usar la calculadora!");
        sc.close();
    }
}
