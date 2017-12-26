/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab8;
import java.util.*;

/**
 *
 * @author andecio
 */
public class Opiniao {
    private int notaProduto;
	private String comentario;
	private GregorianCalendar dataDoComentario;
	
	/**
	 * Construtor da classe, recebe os parametros necessarios a construcao da classe.
	 * @param nota A nota do produto, que deve ser um inteiro entre -2 e 2 (inclusive).
	 * @param comentario O comentario pode conter ate 140 caracteres.
	 * @throws Exception Caso o comentario seja uma string vazia ou null e caso a nota seja invalida.
	 */
	public Opiniao(int nota, String comentario) throws Exception{
		if (comentario == null) throw new Exception("O comentario nao pode ser vazio");
		lancaExcecoes(nota, comentario);
		this.notaProduto = nota;
		this.comentario = comentario;
		this.dataDoComentario = new GregorianCalendar();
	}
	
	
	/**
	 * 
	 * @return O comentario.
	 */
	public String getComentario(){
		return comentario;
	}

	/**
	 * 
	 * @return A data registrada do comentario.
	 */
	public Date getDataDoComentario(){
		return dataDoComentario.getTime();
	}
	
	/**
	 * Retorna uma string no formato: "Nota: X \n
	 * Comentario: X".
	 */
        
    /**
     * Retorna uma string no formato: "Nota: X \n
 Comentario: X".
     * @return
     */
    @Override
	public String toString(){
		return "Nota: " + getNotaProduto() + "\nComentário: " + getComentario();
	}
        
        /**
	 * 
	 * @return A nota do produto.
	 */
	public int getNotaProduto(){
		return notaProduto;
	}
	
	
	/**
	 * True: Caso o comentario, nota e a data sejam iguais; False: Caso contrario.
         * @return 
	 */
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Opiniao)) return false;
		Opiniao outraOpiniao = (Opiniao) obj;
		return outraOpiniao.getNotaProduto() == getNotaProduto() 
				&& outraOpiniao.getComentario().equals(getComentario())
				&& outraOpiniao.getDataDoComentario().equals(getDataDoComentario());
	}
	
	/**
	 * Testa as excecoes do construtor da classe.
	 * @param nota A nota da opiniao.
	 * @param comentario Comentario da opiniao.
	 * @throws Exception Caso a nota seja invalida (fora do intervalo) ou o comentario ultrapasse
	 * os 140 caracteres.
	 */
	private void lancaExcecoes(int nota, String comentario) throws Exception{
		if(!(nota >= -2 && nota <= 2)){
			throw new Exception("Voce tem que atribuir uma nota entre -2 e 2");
		}
		if(comentario.length() > 140){
			throw new Exception("No maximo 140 caracteres");
		}
		if(comentario == ""){
			throw new Exception("O comentario nao pode ser vazio");
		}
	}
}
