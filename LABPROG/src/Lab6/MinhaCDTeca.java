/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab6;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe que contém uma coleção de CD's com métodos para manipulá-los devidamente.
 */

public class MinhaCDTeca {

	private ArrayList<CD> colecaoCDs = new ArrayList<CD>();
	
/**
 * Inicializa o ArrayList que contêm os CDS.
 */
        
	public MinhaCDTeca(){
		this.colecaoCDs = new ArrayList<CD>();
	}
	
/**
 * Inserir CDs á CDTeca com base no ArrayList que contêm vários CDs.
 * @param colecaoCDsRecebido - ArrayList contendo a lista de CDs.
 * @throws Exception Caso o ArrayList informado seja 'null'.
 */
        
	public void adicionarCDs(ArrayList<CD> colecaoCDsRecebido) throws Exception{
		if (colecaoCDsRecebido == null) {
			throw new Exception("A lista de CDs não pode ser null.");
		}
		for (int i = 0; i < colecaoCDsRecebido.size(); i++) {
			colecaoCDs.add(colecaoCDsRecebido.get(i));
		}
	}

        /**
 * Inserir CD.
 * @param inserirCD - Informar o CD a ser inserido.
 * @throws Exception Caso o CD informado seja 'null'.
 */
        
	public void adicionarCD(CD inserirCD) throws Exception{
		if (inserirCD == null){
			throw new Exception("O CD inserido não pode ser null");
		}
		colecaoCDs.add(inserirCD);
	}

/**
 * Remover CD com base no título inserido.
 * @param tituloARemover O titulo do CD que sera removido da colecao.
 * @return 'null': Se não houver um CD com o titulo passado; Retorna o CD caso
 * este seja removido.
 */
        
	public CD removeCD (String tituloARemover) {
		for (CD a: colecaoCDs) {
			if (a.getAlbum().equals(tituloARemover)) {
				colecaoCDs.remove(a);
				return a;
			}
		}
		return null;
	}
	
/**
 * Recebe um ArrayList de CDs a serem removidos.
 * @param cdsARemover ArrayList contendo os objetos a serem removidos.
 * @return True: Se pelo menos um CD for removido da CDTeca;
 * False: Caso nenhum CD seja removido.
 * @throws Exception Caso não tenha sido adicionado nenhum CD a CDTeca e
 * haja a tentativa de remocao.
 */
        
	public boolean removeCDs (ArrayList<CD> cdsARemover) throws Exception{
		if (colecaoCDs.size() == 0) {
			throw new Exception("Não existem CDs na CDTeca, então não há como remover CDs.");
		}
		boolean removeu = false;
		for (CD a: cdsARemover) {
			CD cdremover = pesquisaCD(a.getAlbum());
			if (cdremover != null) {
				removeCD(a.getAlbum());
				removeu = true;
			}
		}
		return removeu;
	}
	
/**
 * Verifica se o CD está contido na CDTeca
 * @param tituloPesquisado A String contendo o titulo do CD
 * @return null: Caso o CD não esteja na colecao; o CD, caso este
 * esteja na colecao.
 */
        
	public CD pesquisaCD (String tituloPesquisado){
		for (CD a: colecaoCDs) {
			if (a.getAlbum().equals(tituloPesquisado)) return a;
		}
		return null;
	}
	
/**
 * Identifica a quantidade de CDs na CDTeca.
 * @return Um nº inteiro contendo o número de CDs da CDTeca.
 */
        
	public int numeroDeCDs (){
		return colecaoCDs.size();
	}
	
/**
 * Retorna um resumo de informações dos CDs contidos na CDTeca incluindo autor, titulo e numero de faixas de cada CD.
        * @return as informações dos CDs
 */
        
	@Override
	public String toString(){
		
                String retorno = new String();
                for (CD a: colecaoCDs) {
			retorno += (a.toString());
		}
		return "-- A CDTeca tem os CDs: --" + retorno;
	}
	
/**
 * Compara se as CDTecas possuem os mesmos CDs.
        * @return True: Caso a CDTeca contenha os mesmos CDs independente da ordem que estes estejam.
 */
        
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof MinhaCDTeca)) return false;
		MinhaCDTeca cdTeca2 = (MinhaCDTeca) obj;
		for (CD a: colecaoCDs) {
			if (cdTeca2.pesquisaCD(a.getAlbum()) == null) return false;
		}
		return true;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.colecaoCDs);
        return hash;
    }
}