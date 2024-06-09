import java.util.*;

public class Grafo {
    Vertice [] listaVertices;
    private int [][] matrizAdyacencia;

    public Grafo (int cantidadVertices){
        matrizAdyacencia = new int [cantidadVertices][cantidadVertices];
        listaVertices = new Vertice[cantidadVertices];

        for (int i=0; i<matrizAdyacencia.length;i++){
            for(int j = 0; j<matrizAdyacencia.length;j++){
                matrizAdyacencia[i][j]=0;
            }
        }
    }

    public void agregarVertice(String etiqueta, int numero){
        Vertice nuevoVertice = new Vertice(etiqueta);
        nuevoVertice.asigVert(numero);
        listaVertices[numero] = nuevoVertice;
    }

    public void agregarArista(){
        Scanner entrada = new Scanner(System.in);
        int origen, destino, opcion;

        do{
            for(int i = 0; i<listaVertices.length; i++){
                System.out.println(i+1+")"+listaVertices[i].getNombre());
            }
            
            do {
                System.out.println("Ingresa el vertice origen");
                origen=validarEnteros(entrada);
                if(origen<1){
                    System.out.println("Error");
                }
            } while (origen<1);

            do {
                System.out.println("Ingresa el vertice destino");
                destino = validarEnteros(entrada);
                if(destino<1){
                    System.out.println("Error");
                }
            } while (destino<1);


            matrizAdyacencia[origen-1][destino-1]=1;

            do {
                System.out.println("Agregar mas aristas 1) SI \t2)NO");
                opcion=validarEnteros(entrada);
                if(opcion<1){
                    System.out.println("Error");
                }
            } while (opcion<1);

        }while(opcion==1);
    }

    public void imprimir(){
        System.out.println("Matriz adyacencia");
        for(int i = 0; i<matrizAdyacencia.length; i++){
            for(int j = 0; j<matrizAdyacencia.length; j++){
                System.out.println(matrizAdyacencia[i][j]+"\t");
                System.out.println();
            }
        }
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

    public Vertice [] getVertices(){
        return this.listaVertices;
    }
}
