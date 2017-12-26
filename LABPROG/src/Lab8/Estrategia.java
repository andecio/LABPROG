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
public class Estrategia {
    
	/**
	 * Retorna a media das opinioes do produto.
	 * @param opinioes ArrayList com todas as opinioes sobre o produto
	 * @return Um double com a media da nota
	 */
    
	public double calculaNotaNaMosca(List<Opiniao> opinioes);

	
	/**
	 * Retorna a lista contendo as opinioes mais relevantes.
	 * @param opinioes ArrayList com todas as opinioes sobre o produto
	 * @return Um ArrayList contendo as opinioes mais relevantes do produto.
	 */
        
	public List<Opiniao> getOpinioesMaisRelevantes(List<Opiniao> opinioes);
                	
	/**
	 * Seleciona os comentarios mais relevantes do ArrayList de opinioes.
	 * @param opinioes ArrayList com todas as opinioes sobre o produto
	 * @return Uma String com os comentarios mais relevantes
	 */
        
	public String escolheComentariosRelevantes(List<Opiniao> opinioes);
	
}