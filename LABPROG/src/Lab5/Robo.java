/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 5 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
 */
package Lab5;

/**
 *
 * @author andecio
 */
public class Robo {
    private int energia, passos, linhaRobo, colunaRobo;
	private Sala salaDoRobo;
	int[] coordenadas = new int[2];
        /**
	 * Construtor para criar o Robo
         * @param energia Energia do robo
         * @param salaRecebida  Objeto Sala
         * @throws java.lang.Exception dasdsadsa
	 */
	public Robo(int energia, Sala salaRecebida) throws Exception {
		if (energia < 0){
			throw new Exception("Valor não pode ser negativo. Insira um valor acima de 0.");
		}else if (energia == 0){
			throw new Exception("O robo tem que ter mais energia, digite um valor maior que 0");
		}if (salaRecebida == null){
			throw new Exception("A sala ainda não foi criada. Por favor, crie uma sala.");
		}if (verificaSalaCheia(salaRecebida)){
			throw new Exception("A sala está totalmente ocupada. Esvazie a sala antes de colocar o robô.");
		}
		this.energia = energia;
		this.passos = 0;
		this.salaDoRobo = salaRecebida;
		coordenadas = getCoordenadas();
		this.linhaRobo = coordenadas[0];
		this.colunaRobo = coordenadas[1];
	}
	/**
	 * Retorna as coordenadas
	 * @return As coordenadas da sala
	 */
	private int[] getCoordenadas() throws Exception{
		int[] coordenada = new int[2];
		if (salaDoRobo.isVazia()) {
			salaDoRobo.setPosicao(0, 0, Sala.OCUPADO);
			coordenada[0] = 0;
			coordenada[1] = 0;
		}else{
			boolean achouLivre = false;
			for (int i = 0; i < salaDoRobo.getNumPosicoesHorizontais(); i++){
				for (int j = 0; j < salaDoRobo.getNumPosicoesVerticais(); j++){
					if (salaDoRobo.getSala()[i][j] == Sala.LIVRE){
						coordenada[1] = j;
						salaDoRobo.setPosicao(i, j, Sala.OCUPADO);
						achouLivre = true;
						break;
					}
				}
				if (achouLivre){
					coordenada[0] = i;
					break;
				}
			}
		}
		return coordenada;
	}
		
	/**
	 * Verifica se a Sala ja esta cheia
	 * @return True: Se estiver cheia
	 * False: Se ja estiver com algum obstaculo
	 */
	private boolean verificaSalaCheia(Sala salaRecebida){
		for (int i = 0; i < salaRecebida.getNumPosicoesHorizontais(); i++){
			for (int j = 0; j < salaRecebida.getNumPosicoesVerticais(); j++){
				if (salaRecebida.getSala()[i][j] != Sala.OBSTACULO){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Verifica a posicao do robo na sala
	 * @return Um array com a posicao do robo
	 */
	public int[] getPosicao(){
		int[] position = new int[2];
		position[0] = linhaRobo;
		position[1] = colunaRobo;
		return position;
	}
	
	/**
	 * Retorna a energia do robo
	 * @return A energia 
	 */
	public int getEnergia(){
		return energia;
	}
	
	/**
	 * Retorna os passos do robo
	 * @return O numero de passos
	 */
	public int getPassos(){
		return passos;
	}
	
	/**
	 * Retorna a sala do Robo criada
	 * @return A sala que contem o robo
	 */
	public Sala getSalaDoRobo(){
		return salaDoRobo;
	}
	
	/**
	* Faz o movimento do robo para cima
         * @return  True: se o movimento acontecer False: Movimentação não ocorre
         * @throws java.lang.Exception  Se a posicao nao estiver livre
	*/
	public boolean andarParaCima() throws Exception{
		if (linhaRobo == 0){
                    return false;
                }
		if (salaDoRobo.isPosicaoLivre((linhaRobo - 1), colunaRobo) && energia > 0){
			salaDoRobo.setPosicao(linhaRobo, colunaRobo, Sala.LIVRE);
			passos++;
			linhaRobo--;
			energia--;
			salaDoRobo.setPosicao(linhaRobo, colunaRobo, Sala.OCUPADO);
			return true;
		}
		return false;
	}
	
	/**
	 * Faz o movimento do robo para baixo
         * @return  True: se o movimento acontecer False: Movimentação não ocorre
         * @throws java.lang.Exception  Se a posicao nao estiver livre
	 */
	public boolean andarParaBaixo() throws Exception {
		if (linhaRobo == (salaDoRobo.getNumPosicoesHorizontais() - 1)){
                    return false;
                }
		if (salaDoRobo.isPosicaoLivre((linhaRobo + 1), colunaRobo) && energia > 0){
			salaDoRobo.setPosicao(linhaRobo, colunaRobo, Sala.LIVRE);
			passos++;
			linhaRobo++;
			energia--;
			salaDoRobo.setPosicao(linhaRobo, colunaRobo, Sala.OCUPADO);
			return true;
		}
		return false;
	}
	
	/**
	 * Faz o movimento do robo para esquerda
         * @return  True: se o movimento acontecer False: Movimentação não ocorre
         * @throws java.lang.Exception  Se a posicao nao estiver livre
	 */
	public boolean andarParaEsquerda() throws Exception{
		if (colunaRobo == 0){
                    return false;
                }
		if (salaDoRobo.isPosicaoLivre(linhaRobo, (colunaRobo - 1)) && energia > 0){
			salaDoRobo.setPosicao(linhaRobo, colunaRobo, Sala.LIVRE);
			passos++;
			colunaRobo--;
			energia--;
			salaDoRobo.setPosicao(linhaRobo, colunaRobo, Sala.OCUPADO);
			return true;
		}
		return false;
	}
	
	/**
	 * Faz o movimento do robo para direita
         * @return  True: se o movimento acontecer False: Movimentação não ocorre
         * @throws java.lang.Exception  Se a posicao nao estiver livre
	 */
	public boolean andarParaDireita () throws Exception{
		if (colunaRobo == (salaDoRobo.getNumPosicoesVerticais() - 1)){
                    return false;
                }
		if (salaDoRobo.isPosicaoLivre(linhaRobo, (colunaRobo + 1)) && energia > 0){
			salaDoRobo.setPosicao(linhaRobo, colunaRobo, Sala.LIVRE);
			passos++;
			colunaRobo++;
			energia--;
			salaDoRobo.setPosicao(linhaRobo, colunaRobo, Sala.OCUPADO);
			return true;
		}
		return false;
	}
	
	/**
	 * Faz a comparação de um robo com outro
	 * @param outroRobo Outro objeto robo
         * @return  True: Se a comparação for verdadeira False: Se a comparação for falsa
	 */
	public boolean equals(Robo outroRobo){
		if (salaDoRobo.equals(outroRobo.getSalaDoRobo())){
			if (getPosicao()[0] == outroRobo.getPosicao()[0] && getPosicao()[1] == outroRobo.getPosicao()[1]){
				return true;
			}
		}
		return false;
	}
}
