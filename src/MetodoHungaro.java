import java.util.Scanner;
 
public class MetodoHungaro {
 
    public static void subtraiLinha(int m[][], int n, int menor) {
        for (int i = 0; i < n; i++) {
            menor = m[i][0];
            // procura o menor elemento da linha
            for (int j = 0; j < n; j++) {
                if (m[i][j] < menor) {
                    menor = m[i][j];
 
                }
            }
            // diminui todos os elementos da linha do menor
            for (int j = 0; j < n; j++) {
                m[i][j] -= menor;
            }
            menor = 0;
        }
    }
 
    public static int[][] subtraiColuna(int m[][], int n, int menor) {
 
        for (int j = 0; j < n; j++) {
            menor = m[0][j];
            for (int i = 0; i < n; i++) {
                if (m[i][j] < menor) {
                    menor = m[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                m[i][j] -= menor;
            }
            menor = 0;
        }
        return m;
    }
 
    public static void imprimeMatriz(int m[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Número de tarefas a serem otimizadas: ");
        int n = in.nextInt();
        int m = 0;
 
        int[][] matriz = new int[n][n];
 
        System.out.println("Insira tarefas a serem otimizadas linha a linha: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = in.nextInt();
            }
        }
 
        imprimeMatriz(matriz, n);
        subtraiLinha(matriz, n, m);
        subtraiColuna(matriz, n, m);
        imprimeMatriz(matriz, n);
 
        in.close();
 
    }
 
}


