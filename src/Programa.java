import java.util.Scanner;
public class Programa {

	public static void main(String[] args) {
		System.out.print("Informe a ordem da matriz-custo: ");
		Scanner in = new Scanner(System.in);
		int tamanho=in.nextInt();
		int[][] matriz=new int[tamanho][tamanho];
		System.out.println("Informe a matriz custo: ");
		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){
				matriz[i][j]=in.nextInt();
			}
		}
		in.close();
		AlocacaodeTarefas teste= new AlocacaodeTarefas(tamanho,matriz);
		matriz = teste.getMatriz();
		System.out.println("-MATRIZ COM ALOCAÇÃO OTIMA DE ZEROS-");
		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
	}
}

