import java.util.Scanner;
public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int tamanho=in.nextInt();
		int[][] matrix=new int[tamanho][tamanho];
		int[][] matrizOriginal=new int[tamanho][tamanho];
		int b;
		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){
				b=in.nextInt();
				matrix[i][j]=b;
				matrizOriginal[i][j]=b;
			}
		}
		
		AlocacaodeTarefas teste= new AlocacaodeTarefas(tamanho,matrix);
		teste.metodoHungaro();
		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){
				System.out.print(matrizOriginal[i][j]+" ");
			}
			System.out.println();
		}
		int[] x = teste.getResultado();
		for(int i=0;i<tamanho;i++){
			System.out.println(x[i]);
		}
	}
}

