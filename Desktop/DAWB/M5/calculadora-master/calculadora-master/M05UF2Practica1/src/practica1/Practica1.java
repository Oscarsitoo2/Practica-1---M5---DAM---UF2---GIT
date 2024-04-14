/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar;

        do {
            String operacion = obtenerOperacion(sc);
            double num1 = obtenerNumero(sc, "primer");
            double num2 = obtenerNumero(sc, "segundo");

            double resultado = calcularResultado(operacion, num1, num2);
            System.out.println("(" + num1 + ") " + operacion + " (" + num2 + ")" + " = " + resultado);

            continuar = continuarOperando(sc);
        } while (continuar);

        System.out.println("\n\t|---ADIOS---|");
    }

    public static String obtenerOperacion(Scanner sc) {
        String operacion;
        do {
            System.out.println("\n |---Bienvenido a la calculadora KEKOÑETE!!!---|");
            System.out.println("\n Operación? (Indica el signo)\n");
            System.out.println(" + | sumar \n - | restar \n"
                    + " x | multiplicar \n / | dividir \n * | elevar primer num al segon num."
                    + "\n % | residu");
            operacion = sc.nextLine();
        } while (!esOperacionValida(operacion));

        return operacion;
    }

    public static boolean esOperacionValida(String operacion) {
        return operacion.matches("[+\\-xX/*%]");
    }

    public static double obtenerNumero(Scanner sc, String orden) {
        String numero;
        do {
            System.out.println("\n --- Introduzca el " + orden + " número. ---");
            numero = sc.nextLine();
        } while (!esNumeroValido(numero));

        return Double.parseDouble(numero);
    }

    public static boolean esNumeroValido(String numero) {
        return numero.matches("[+-]?[\\d]*[.]?[\\d]+");
    }

    public static double calcularResultado(String operacion, double num1, double num2) {
        switch (operacion) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "x":
            case "X":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    System.err.println("Error: No se puede dividir por cero.");
                    return Double.NaN;
                }
                return num1 / num2;
            case "*":
                return Math.pow(num1, num2);
            case "%":
                if (num2 == 0) {
                    System.err.println("Error: No se puede calcular el residuo de la división por cero.");
                    return Double.NaN;
                }
                return num1 % num2;
            default:
                System.err.println("Error: Operación no válida.");
                return Double.NaN;
        }
    }

    public static boolean continuarOperando(Scanner sc) {
        System.out.println("\n ---¿Desea continuar operando?--- \n");
        System.out.println(" [s/n]");

        String respuesta;
        do {
            respuesta = sc.nextLine().toLowerCase();
            if (!respuesta.equals("s") && !respuesta.equals("n")) {
                System.err.println("\n Error, por favor ingrese 's' para continuar o 'n' para salir. \n");
            }
        } while (!respuesta.equals("s") && !respuesta.equals("n"));

        return respuesta.equals("s");
    }
}
