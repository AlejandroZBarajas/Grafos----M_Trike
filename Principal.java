import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        
        do {
            System.out.println("Indica la cantidad de vertices del grafo");
            cantidad=validarEnteros(entrada);
            if(cantidad<1){
                System.out.println("Error");
            }
        } while (cantidad<1);

        Grafo grafo = new Grafo(cantidad);
        
        for(int i =0; i<cantidad; i++){
            System.out.println("Ingresa el valor del vertice");
            grafo.agregarVertice(entrada.next(), i);
        }
        grafo.agregarArista();
        grafo.imprimir();
    }

    private static int validarEnteros(Scanner scanner) { 
        int input;  
        while (true) {
            try {
                input = scanner.nextInt();
                break;}
            catch (InputMismatchException e)  {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); 
            }
        }
        return input; 
    }
}
