import java.util.*;

public class Cartas {
    public static void main(String[] args) {
        List<int[]> jugadas = jugadas(5);

        System.out.println("List.toArray: " + Arrays.deepToString(jugadas.toArray())); //imprime el list.toArray

        /*
         * Genera un arreglo multidimensional del tamaño de la lista
         * Itera la lista para pasar los arreglos contenidos al nuevo arreglo
         */
        int[][] a = new int[jugadas.size()][];
        for (int i = 0; i < jugadas.size(); i++) {
            a[i] = jugadas.get(i);
        }
        System.out.println("ARRAY: " + Arrays.deepToString(a)); //imprime el arreglo multidimensional

        int[] arre = aplanar(a); //aplana el arreglo multidimensional
        System.out.println("arreglo aplanado: " + Arrays.toString(arre)); //imprime el arreglo aplanado (unidimensional)
    }

    /*
     * Genera lista con N cantidad de arreglos de dimension al azar con valores al azar
     * donde N es la cantidad de jugadores q recibe como parametro
     */
    private static List<int[]> jugadas(int jugadores) {
        Random random = new Random();
        int min = 1;
        int max = 13;
        List<int[]> jugadas = new ArrayList<int[]>();

        for (int i = 0; i < jugadores; i++) {
            int cartas[] = new int[(random.nextInt(max - min) + min)];
            for (int j = 0; j < cartas.length; j++) {
                cartas[j] = random.nextInt(max - min) + min;
            }
            jugadas.add(cartas);
        }
        return jugadas;
    }

    /*
     * Toma un arreglo de int multidimencional,
     * lo recorre para calcular el tamaño total debido a que cada arreglo contenido puede tener una dimension diferente
     * Lo vuelve a recorrer, almacenando en un arreglo unidimensional que se creo con el tamaño calculado del multidimensional
     * lo llena con los valores del multidimensional y devuelve el arreglo unidimensional.
     */
    private static int[] aplanar(int[][] arreglo) {
        int acumulador = 0;
        for (int[] arr : arreglo) {
            acumulador += arr.length;
        }
        int[] arregloAplanado = new int[acumulador];
        int x = 0;
        for (int i[] : arreglo) {
            for (int j = 0; j < i.length; j++) {
                arregloAplanado[x] = i[j];
                x++;
            }
        }
        return arregloAplanado;
    }

}
