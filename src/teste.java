import java.util.Scanner;
public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = in.nextInt();
            }
        }
        AlocacaodeTarefas x = new AlocacaodeTarefas(matriz,n);
        System.out.println(x.contarRiscos());
        x.imprimeMatrizH();
        x.imprimeMatrizV();
        in.close();
	}

}
