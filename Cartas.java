import java.util.*;

public class Cartas {
    public static void main(String[] args) {
        List<int[]> jugadas = jugadas(5);

        System.out.println("List.toArray: " + Arrays.deepToString(jugadas.toArray()));

        int[][] a = new int[jugadas.size()][];
        for (int i = 0; i < jugadas.size(); i++) {
            a[i] = jugadas.get(i);
        }
        System.out.println("ARRAY: " + Arrays.deepToString(a));

        int[] arre = aplanar(a);
        System.out.println("arreglo aplanado: " + Arrays.toString(arre));
    }

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
