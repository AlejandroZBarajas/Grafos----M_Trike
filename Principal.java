import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidad;

        do {
            System.out.println("Indica la cantidad de vertices del grafo");
            cantidad = validarEnteros(entrada);
            if (cantidad < 1) {
                System.out.println("Error");
            }
        } while (cantidad < 1);

        Grafo grafo = new Grafo(cantidad);

        int valorVertice;

        for (int i = 0; i < cantidad; i++) {
            do {

                System.out.println("Ingresa el valor del vertice: " + (i + 1) + "(Multiplos de dos): ");

                valorVertice = validarEnteros(entrada);

                if (validarMultiploDos(valorVertice)) {
                    System.out.println("\n---Debe ser un multiplo de dos---");
                } else if (validarExistenciaVertice(grafo, valorVertice)) {
                    System.out.println("\n---Vertice duplicado---");
                }

            } while (validarMultiploDos(valorVertice) || validarExistenciaVertice(grafo, valorVertice));
            grafo.agregarVertice(String.valueOf(valorVertice), i);

        }
        grafo.agregarArista();
        grafo.imprimir();
    }

    private static int validarEnteros(Scanner scanner) {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next();
            }
        }
        return input;
    }

    private static boolean validarMultiploDos(int num) {
        if ((num % 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean validarExistenciaVertice(Grafo grafo, int valorVertice) {
        Vertice verticesAVerificar[] = grafo.getVertices();
        boolean duplicado = false;

        for (int i = 0; i < verticesAVerificar.length; i++) {
            if (verticesAVerificar[i] != null) {
                if (verticesAVerificar[i].getNombre().equals(String.valueOf(valorVertice))) {
                    duplicado = true;
                }
            }

        }

        return duplicado;
    }
}
