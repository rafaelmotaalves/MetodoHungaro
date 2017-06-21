
public class HungaroMetodo {
	private int[][] matriz;
	private int[][] matrizOriginal;
	private int tamanho;
	private boolean[][] riscoslinha;
	private boolean[][] riscoscoluna;
	public HungaroMetodo(int tamanho,int[][] m){
		this.setTamanho(tamanho);
		this.setMatriz(m);
		this.setMatrizOriginal(m);
		this.riscoslinha=new boolean[tamanho][tamanho];
		this.riscoscoluna=new boolean[tamanho][tamanho];
	}
	public int[][] getMatriz() {
		return matriz;
	}
	public void setEMatriz(int i,int j,int x) {
		int aux[][]=this.matriz;
		aux[i][j]=x;
		setMatriz(aux);
	}
	public void setMatriz(int[][] matriz){
		this.matriz=matriz;
	}
	public int[][] getMatrizOriginal() {
		return matrizOriginal;
	}
	public void setMatrizOriginal(int[][] matrizOriginal) {
		this.matrizOriginal = matrizOriginal;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public void subtraiLinha(){
		
	}
}
