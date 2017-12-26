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
public class EstrategiaSimples {
    private Opiniao comentarioMaisRelevantePositivo;
	private Opiniao comentarioMaisRelevanteNegativo;
	
	/**
	 * Calcula a nota fazendo a media aritmetica e retornando o valor
	 * Se nao tiver nenhuma nota o retorno e zero
     * @param opinioes
     * @return 
	 */
        
	@Override
	public double calculaNotaNaMosca(List<Opiniao> opinioes){
		if(opinioes.size() < 1){
                    return 0;
                }
		int soma = 0;
		for(Opiniao a: opinioes){
			soma += a.getNotaProduto();
		}
		int media = soma / opinioes.size();
		return media;
	}

	/**
	 * O metodo retorna uma string contendo as duas opinioes mais recentes, com suas respectivas
	 * notas, comentarios e datas.
     * @param opinioes
     * @return 
	 */
        
	@Override
	public String escolheComentariosRelevantes(List<Opiniao> opinioes){
		if(opinioes.size() < 1){
			return null;
		}
		if(opinioes.size() == 1){
			return "Comentário mais relevante: " + "\nNota: " + opinioes.get(0).getNotaProduto()
					+ " || Comentário: " + opinioes.get(0).getComentario();
		}
		
		selecionaOpinioesRelevantes(opinioes);
		
		return "Comentário com avaliação mais positiva: \n" + "Nota: " + comentarioMaisRelevantePositivo.getNotaProduto() + " || Comentário: " + comentarioMaisRelevantePositivo.getComentario()
		+ "\n\nComentário com avaliação mais negativa: \n" + "Nota: " + comentarioMaisRelevanteNegativo.getNotaProduto() + " || Comentário: " + comentarioMaisRelevanteNegativo.getComentario() + "\n";
	}

	/**
	 * Retorna um List contendo as duas opinioes mais recentes sobre o produto.
     * @param opinioes
     * @return 
	 */
        
	@Override
	public List<Opiniao> getOpinioesMaisRelevantes(List<Opiniao> opinioes){
		List<Opiniao> opinioesMaisRelevantes = new ArrayList<Opiniao>();
		escolheComentariosRelevantes(opinioes);
		opinioesMaisRelevantes.add(comentarioMaisRelevantePositivo);
		opinioesMaisRelevantes.add(comentarioMaisRelevanteNegativo);
		return opinioesMaisRelevantes;
	}
	
	/**
	 * Seleciona as tres opinioes mais recentes baseada nas datas dos comentarios.
	 * @param opinioes List contendo as opinioes
	 */
        
	private void selecionaOpinioesRelevantes(List<Opiniao> opinioes){
		int maior = opinioes.get(0).getNotaProduto();
		int menor = opinioes.get(1).getNotaProduto();
		comentarioMaisRelevantePositivo = opinioes.get(0);
		comentarioMaisRelevanteNegativo = opinioes.get(1);
		for(Opiniao a: opinioes){
			if(a.getNotaProduto() > maior){
				maior = a.getNotaProduto();
				comentarioMaisRelevantePositivo = a;
			}
			else if(a.getNotaProduto() == maior){
				if (a.getDataDoComentario().before(comentarioMaisRelevantePositivo.getDataDoComentario())) {
					comentarioMaisRelevantePositivo = a;
				}
			}
			
			if(a.getNotaProduto() < menor){
				menor = a.getNotaProduto();
				comentarioMaisRelevanteNegativo = a;
			}
			else if(a.getNotaProduto() == menor){
				if(a.getDataDoComentario().before(comentarioMaisRelevanteNegativo.getDataDoComentario())){
					comentarioMaisRelevanteNegativo = a;
				}
			}
		}
	}
}