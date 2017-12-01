/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab7;
import java.util.*;
public class Taxistas extends Rodoviarios {
	private int passageiros;
	private static double somaBensTaxistas;
	private static double limiarRiquezaTax;
	public static List<Taxistas> taxistas = new ArrayList<Taxistas>();
        
        /**
	 * Constroi um contribuinte taxista a partir dos parametros passados.
	 * @param nomeContribuinte O nome do contribuinte.
	 * @param numeroContribuinte O numero de cadastro do contribuinte.
	 * @param quilometrosPercorridos A quantidade de quilometros percorrida em um ano.
	 * @param passageiros A quantidade de passageiros transportados em um ano.
	 * @param valorCarro O valor do carro, se possuir.
	 * @param valorCasa O valor da casa, se possuir.
	 * @throws Exception Caso algum dos valores passados sejam negativos ou
	 * strings vazias.
	 */
        
	public Taxistas(String nomeContribuinte, String numeroContribuinte, double quilometrosPercorridos, int passageiros, double valorCarro, double valorCasa) throws Exception {
		super(nomeContribuinte, numeroContribuinte, quilometrosPercorridos, valorCarro, valorCasa);
		if (passageiros < 0) {
			throw new Exception("O número de passageiros não pode ser negativo.");
		}
		this.passageiros = passageiros;
		calculaTributacao();
		descontoTributacao();
		if (!verificaSeExiste(nomeContribuinte, numeroContribuinte)) {
			taxistas.add(this);
			numeroDeContribuintes++;
		}
	}
	@Override
	public void calculaTributacao() {
		tributacao = passageiros * 0.5;
	}
	private boolean verificaSeExiste (String nome, String numero) {
		for (Taxistas a: taxistas) {
			if (a.getNomeContribuinte().equals(nome) || a.getNumeroContribuinte().equals(numero)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Atualiza a lista de taxistas e consequentemente o limiar de riqueza
	 * destes. Caso ele esteja acima do limiar, sera atribuido um boolean true a ele.
	 * Caso contrario, sera atribuido um boolean false.
	 */
	public static void atualizaContribuintesLimiarRiqueza () {
		atualizaLimiarRiqueza();
		for (Taxistas a: taxistas) {
			if (a.sinaisRiqueza >= limiarRiquezaTax) {
				a.setRiquezaExcessiva(true);
			}
		}
	}
        
        	private static void atualizaLimiarRiqueza () {
		somaBensTaxistas = 0.0;
		limiarRiquezaTax = 0.0;
		for (Taxistas a: taxistas) {
			somaBensTaxistas += (a.sinaisRiqueza);
		}
		limiarRiquezaTax = (somaBensTaxistas / taxistas.size()) * 1.5;
	}
	
	/**
	 * 
	 * @return Os passageiros transportados em um ano
	 */
                
	public int getPassageiros () {
		return passageiros;
	}
	
	/**
	 * 
	 * @return O numero de taxistas cadastrados.
	 */
        
	public static int getNumeroDeTaxistas () {
		return taxistas.size();
	}
	
	/**
	 * 
	 * @return A lista estatica da classe contendo os objetos.
	 */
        
	public static List<Taxistas> getTaxistas () {
		return taxistas;
	}
	
	/**
	 * 
	 * @return O limiar de riqueza da classe.
	 */
        
	public static double getLimiarRiqueza () {
		return limiarRiquezaTax;
	}
	
	/**
	 * Retorna true se o nome e numero de contribuinte forem iguais.
	 */
        
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof Taxistas)) {
			return false;
		}
		Taxistas outroTaxista = (Taxistas) obj;
		return outroTaxista.getNomeContribuinte().equals(getNomeContribuinte()) && outroTaxista.getNumeroContribuinte().equals(getNumeroContribuinte());
	}
	
	public static String consultaContribuinte (String nome, String numeroContr) {
		for (Taxistas a: taxistas) {
			if (nome.equals(a.getNomeContribuinte()) && numeroContr.equals(a.getNumeroContribuinte())) {
				return "Nome: " + a.getNomeContribuinte() + " - Número de contribuinte: " + a.getNumeroContribuinte() +
						"\nTributação bruta: R$ " + a.getTributacao() + "\nDescontos: R$ " + a.getDescontos() + "\nTributação Total: R$ " + a.getTributacaoTotal() + "\n";
			}
		}
		return "Pessoa não encontrada.";
	}
}
