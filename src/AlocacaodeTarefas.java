
public class AlocacaodeTarefas {
	private int[][] matrizOriginal;
	private int[][] matriz;
	private int tamanho;
	private boolean[][] riscoslinha;
	private boolean[][] riscoscoluna;
	
	public AlocacaodeTarefas(int[][] matriz,int tamanho){
		this.matriz=matriz;
		this.matrizOriginal=matriz;
		this.tamanho=tamanho;
	}
    public void subtraiLinha( int tamanho) {
        int menor;
    	for (int i = 0; i < tamanho; i++) {
            menor = matriz[i][0];
            // procura o menor elemento da linha
            for (int j = 0; j < tamanho; j++) {
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
 
                }
            }
            // diminui todos os elementos da linha do menor
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] -= menor;
            }
        }
    }
    public void subtraiColuna( int tamanho) {
    	int menor;
        for (int j = 0; j < tamanho; j++) {
            menor = matriz[0][j];
            for (int i = 0; i < tamanho; i++) {
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                }
            }
            for (int i = 0; i < tamanho; i++) {
                matriz[i][j] -= menor;
            }
            menor = 0;
        }
    }
    
	public int riscarLinhas(int parametro){
		int n=0;
		this.riscoslinha=new boolean[tamanho][tamanho];
		this.riscoscoluna=new boolean[tamanho][tamanho];
		for(int i=0;i<tamanho;i++ ){
			for(int j=0;j<tamanho;j++){
				if(matriz[i][j]==0 && !(riscoslinha[i][j] || riscoscoluna[i][j]) ){
					int nlinha=0 ,ncoluna=0;
					for(int x=0; x<tamanho;x++){
						if(matriz[i][x]==0 && !(riscoslinha[i][x] || riscoscoluna[i][x])){
							nlinha++;
						}
						if(matriz[x][j]==0 && !(riscoslinha[x][j] || riscoscoluna[x][j])){
							ncoluna++;
						}
					}
					if(parametro==1){
						n++;
						if(nlinha>=ncoluna){
							riscarLinha(i);
						}else{
							riscarColuna(j);
						}
					}else{
						n++;
						if(nlinha>ncoluna){
							riscarLinha(i);
						}else{
							riscarColuna(j);
						}
					}
				}
			}
		}
		return n;
	}
	public void riscarLinha(int i){
		for(int x=0;x<tamanho;x++){
			riscoslinha[i][x]=true;
		}
	}
	public void riscarColuna(int j){
		for(int x=0;x<tamanho;x++){
			riscoscoluna[x][j]=true;
		}
	}
	public int contarRiscos(){
		int a =riscarLinhas(1);
		int b= riscarLinhas(2);
		if(a<b){
			return riscarLinhas(1);
		}else{
			return riscarLinhas(2);
		}
	}
    public void imprimeMatrizH() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(riscoslinha[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public void imprimeMatrizV () {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j <tamanho ; j++) {
                System.out.print(riscoscoluna[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
