import java.util.Scanner;
public class ProgramaTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [][] original = new int[n][n];
		int [][] a = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int b =in.nextInt();
				original[i][j]=b;
				a[i][j]=b;
			}
		}
		HungaroMetodo teste = new HungaroMetodo(n,original);
		teste.setEMatriz(0,0,100);
		for(int x=0;x<n;x++){
			for(int y=0;y<n;y++){
				System.out.print(a[x][y]+" ");
			}
			System.out.println();
		}
	}

}
