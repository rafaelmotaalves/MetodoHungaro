
public class AlocacaodeTarefas {
	private int[][] matriz;
	private int tamanho;
	private boolean[][] riscoslinha;
	private boolean[][] riscoscoluna;
	/**
	 * 	Executa a Alocação de tarefas Otima.
	 * @param tamanho
	 * 		Quantidade de Colunas/Linhas da matriz quadrada
	 * @param matriz
	 * 		Matriz-custo quadrada com entradas inteiras representando o problema de alocação de tarefas
	 * 		onde a coluna representa o a tarefa a ser realizada e a linha o custo de cada opção.
	 */
	public AlocacaodeTarefas(int tamanho,int[][] matriz){
		this.tamanho=tamanho;
		this.matriz=matriz;
		metodoHungaro();
		}
    /**
     * 		Subtrai a menor entrada de cada linha de todas as entradas da mesma linha
     *
     */
    public void subtraiLinha() {
        int menor;
    	for (int i = 0; i < tamanho; i++) {
            menor = this.matriz[i][0];
            for (int j = 0; j < tamanho; j++) {
                if (this.matriz[i][j] < menor) {
                    menor = this.matriz[i][j];
                }
            }
            for (int j = 0; j < tamanho; j++) {
                this.matriz[i][j] -= menor;
            }
        }
    }
    /**
     * 	Subtrai a menor entrada de cada coluna de todas as entradas da mesma coluna.
     *
     */
    public void subtraiColuna() {
    	int menor;
        for (int j = 0; j < tamanho; j++) {
            menor = this.matriz[0][j];
            for (int i = 0; i < tamanho; i++) {
                if (this.matriz[i][j] < menor) {
                    menor = this.matriz[i][j];
                }
            }
            for (int i = 0; i < tamanho; i++) {
                this.matriz[i][j] -= menor;
            }
            menor = 0;
        }
    }
	/**
	 * 	Atribui a todos os valores de determinada linha o valor true (equivalente a
	 * riscar um traço na horizontal).
	 * @param i
	 * 		Linha em que o metodo vai ser realizado.
	 */
	public void riscarLinha(int i){
		for(int x=0;x<tamanho;x++){
			riscoslinha[i][x]=true;
		}
	}
	/**
	 * 	Atribui a todos os valores de determinada coluna o valor false (equivalente a riscar
	 * um traço na vertical)
	 * @param j
	 * 		Coluna em que o metodo vai ser realizado.
	 */
	public void riscarColuna(int j){
		for(int x=0;x<tamanho;x++){
			riscoscoluna[x][j]=true;
		}
	}
    /**
     * 	Risca traços através de Linhas e Colunas de forma que todas entradas contendo zeros são riscadas
     * (os traços são representados por matrizes booleanas de tamanho igual a matriz-custo uma representando os traços
     * horizontais e a outra representando os traços verticais) testando toda vez que acha uma entrada zero se ela ja foi riscada
     * e se existem mais outras entradas zero não riscadas na sua horizontal ou na sua vertical e riscando a linha e somando 1 um contador 
     * toda vez que uma linha for riscada;  
     * @param parametro
     * 	 	Quando for efetuado o teste da quantidade de zeros na horizontal ou vertical o parametro vai determinar que direção
     * 		vai ser favorecida caso a quantidade de entradas zero seja a mesma nas duas direções. 
     * @return
     * 		Retorna a quantidade linhas riscadas neste caso.
     */

	public int riscarTracos(int parametro){
		int n=0;
		this.riscoslinha=new boolean[tamanho][tamanho];
		this.riscoscoluna=new boolean[tamanho][tamanho];
		for(int i=0;i<tamanho;i++ ){
			for(int j=0;j<tamanho;j++){
				if(this.matriz[i][j]==0 && !(riscoslinha[i][j] || riscoscoluna[i][j]) ){
					int nlinha=0 ,ncoluna=0;
					for(int x=0; x<tamanho;x++){
						if(this.matriz[i][x]==0 && !(riscoslinha[i][x] || riscoscoluna[i][x])){
							nlinha++;
						}
						if(this.matriz[x][j]==0 && !(riscoslinha[x][j] || riscoscoluna[x][j])){
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
	/** 
	 * 	Testa os dois casos do metodo riscarLinhas favorecendo as duas direções e verificando 
	 *em qual das duas formas são riscados menos traços
	 * @return
	 * 		Retorna de que forma os traços são riscados de forma otima.
	 */
	public int contarRiscos(){
		int a =riscarTracos(1);
		int b= riscarTracos(2);
		if(a<b){
			return riscarTracos(1);
		}else{
			return riscarTracos(2);
		}
	}
/**
 * 	Testa se o o numero minimo de linhas riscadas é igual à ordem da matriz, Caso isso aconteça
 * há uma alocação perfeita de zeros e o programa é encerrado, Caso isso não ocorra ele chama o 
 * método naoEstaOtimizado e depois chama a si mesmo recursivamente para que o teste seja executado
 * novamente.
 */
public void testeDeOtimalidade(){
		int n=contarRiscos();
		if(n!=this.tamanho) {
			naoEstaOtimizado();
			testeDeOtimalidade();
		}
	}
/**
 * 	Executa o método hungaro na matriz-custo.
 */
public void metodoHungaro(){
	subtraiLinha();
	subtraiColuna();
	testeDeOtimalidade();
}
/**
 *	Determina a menor entrada não riscada por nenhum traço. Subtrai esta entrada de todas
 *as entradas não riscadas e depois a soma a todas as entradas riscadas tanto horizontais
 *quanto verticalmente.
 */
	public void naoEstaOtimizado(){
		int menor=1;
		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){
				if(this.matriz[i][j]<menor && !(riscoslinha[i][j] || riscoscoluna[i][j]) ){
					menor=this.matriz[i][j];
				}
			}
		}
		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){
				if(!(riscoslinha[i][j] || riscoscoluna[i][j]) ){
					this.matriz[i][j]=this.matriz[i][j]- menor;
				}else if(riscoslinha[i][j] && riscoscoluna[i][j]){
					this.matriz[i][j]=this.matriz[i][j]+menor;
				}
			}
		}
	}
	public int[][] getMatriz() {
		return this.matriz;
	}

    
}
