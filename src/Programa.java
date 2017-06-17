import java.util.Scanner;
public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int tamanho=in.nextInt();
		int[][] matrix=new int[tamanho][tamanho];
		int[][] a=new int[tamanho][tamanho];
		int b;
		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){
				b=in.nextInt();
				matrix[i][j]=b;
				a[i][j]=b;
			}
		}
		
		AlocacaodeTarefas teste= new AlocacaodeTarefas(tamanho,matrix);
		teste.metodoHungaro();
		int[] resposta=teste.getResultado(a);
		for(int i=0;i<tamanho;i++){
			System.out.println(resposta[i]);
		}
		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
