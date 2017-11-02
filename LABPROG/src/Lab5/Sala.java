/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 5 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
 */
package Lab5;

/**
 *
 * @author andecio
 */
public class Sala {

    /**
     *
     */
    final public static char OCUPADO = 'O';

    /**
     *
     */
    final public static char LIVRE = ' ';

    /**
     *
     */
    final public static char OBSTACULO = 'X';
	private char[][] sala;
	private int numerodelinhas;
	private int numerodecolunas;
	
    /**
     *
     * @param NUM_LINHAS
     * @param NUM_COLUNAS
     * @throws Exception
     */
    public Sala(int NUM_LINHAS, int NUM_COLUNAS) throws Exception {
		if (NUM_LINHAS <= 0 || NUM_COLUNAS <= 0) {
			throw new Exception("Dados errados para a criacao da sala. A dimensao tem que ser maior que 0");
		}
		this.sala = new char[NUM_LINHAS][NUM_COLUNAS];
			for(int i = 0; i < NUM_LINHAS; i++){
				for(int j = 0; j < NUM_COLUNAS; j++){
					sala[i][j] = LIVRE;
				}
			}
			this.numerodelinhas = NUM_LINHAS;
			this.numerodecolunas = NUM_COLUNAS;
		}
	
	/**
	 * Retorna o numero de linhas da sala criada
	 * @return O numero de linhas da sala.
	 */
	public int getNumPosicoesHorizontais() {
		return numerodelinhas;
	}
	
	/**
	 * Retorna o numero de colunas da sala criada
	 * @return o numero de colunas da sala.
	 */
	public int getNumPosicoesVerticais(){
		return numerodecolunas;
	}
	
	/**
	 * Retorna a sala que foi criada, com espacos livres e obstaculos
	 * @return Uma matriz de char contendo os espacos livres e obstaculos da sala.
	 */
	public char[][] getSala(){
		return sala;
	}
	
	/**
	 * Faz uma verificação se a sala se encontra vazia
	 * @return True: Sala vazia; False: Se tiver um obstaculo
	 */
	public boolean isVazia() {
		for (int i = 0; i < numerodelinhas; i++){
			for (int j = 0; j < numerodecolunas; j++) {
				if (sala[i][j] != LIVRE) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Adiciona um obstaculo na posicao informada
	 * @param linha Recebe a linha
	 * @param coluna Recebe a coluna
         * @return  True: Se adicionar o obstaculo False: Se a posicao estiver invalida
         * @throws java.lang.Exception  Se a posição não esta livre
	 */
	public boolean inserirObstaculo(int linha, int coluna) throws Exception{
		if (!(posicaoValida(linha, coluna))){
			return false;
		}if (isPosicaoLivre(linha, coluna)){
				sala[linha][coluna] = OBSTACULO;
				return true;
			}
			return false;
	}
	
	/**
	 * Verifica se a posicao se encontra dentro da sala
	 * @param linha Recebe a linha
	 * @param coluna Recebe a coluna
	 * @return True: Se estiver na sala; False: Se estiver fora da sala.
	 */
	public boolean posicaoValida(int linha, int coluna) {
		if ((linha < 0 || linha >= numerodelinhas) || (coluna < 0 || coluna >= numerodecolunas)) {
                    return false;
                }else{
		return true;
                }
	}
	
	/**
	 * Verifica se a posicao esta livre
	 * @param linha Recebe linha
	 * @param coluna Recebe coluna
         * @return True se estiver livre e False se a sala estiver vazia
         * @throws java.lang.Exception  Se a posição nao for valida
	 * 
	 */
	public boolean isPosicaoLivre(int linha, int coluna) throws Exception{
		if (!(posicaoValida(linha, coluna))){
			throw new Exception("Posicao inexistente.");
		}
		if (sala[linha][coluna] == LIVRE){ 
                    return true;
                }else{
		return false;
                }
	}
	
	/**
	 * Define a posicao dada como livre ou ocupada a partir dos parametros.
	 * @param linha A linha
	 * @param coluna A coluna
	 * @param statusPosicao Como esta a posicao
	 * @return True: Se a posicao estiver livre e se queira colocar um obstaculo nessa posicao.
	 * Se a posicao estiver ocupada e se queira deixar a posicao livre; 
	 * False: Se a posicao estiver ocupada e se queira inserir um obstaculo.
	 */
	public boolean setPosicao (int linha, int coluna, char statusPosicao){
		if ((linha < 0 || linha >= numerodelinhas) || (coluna < 0 || coluna >= numerodecolunas)){
			return false;
		}
		if (statusPosicao == LIVRE) {
			sala[linha][coluna] = LIVRE;
			return true;
		}
		else {
			sala[linha][coluna] = OCUPADO;
			return true;
		}
	}
	
	/**
	 * Compara uma sala com outra previamente criada.
	 * @param outraSala Recebe a sala que deseja fazer a comparação
	 * @return True: Se as salas apresentarem os mesmos obstaculos; False: Se apresentarem
	 * obstaculos diferentes ou tamanhos diferentes.
	 */
	public boolean equals(Sala outraSala){
		if (outraSala.getNumPosicoesHorizontais() != numerodelinhas || outraSala.getNumPosicoesVerticais() != numerodecolunas){
			return false;
		}else{
			for (int i = 0; i < numerodelinhas; i++){
				for (int j = 0; j < numerodecolunas; j++){
					if (sala[i][j] != outraSala.sala[i][j]){
						return false;
					}
				}
			}
			return true;
		}
	}
}
