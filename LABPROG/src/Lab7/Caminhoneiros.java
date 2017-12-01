/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab7;
import java.util.ArrayList;
import java.util.List;
public class Caminhoneiros extends Rodoviarios {
	private static final int IMPOSTO_FIXO = 500;
	private double toneladasAno;
	private static double somaRiquezasCam;
	private static double limiarRiquezaCam;
	private static List<Caminhoneiros> caminhoneiros = new ArrayList<Caminhoneiros>();
	public Caminhoneiros (String nomeContribuinte, String numeroContribuinte, double toneladasAno, double quilometros_percorridos, double valorCarro, double valorCasa) throws Exception {
		super(nomeContribuinte, numeroContribuinte, quilometros_percorridos, valorCarro, valorCasa);
		if (verificaSeENegativo(toneladasAno)) {
			throw new Exception("Os quilômetros percorridos e as toneladas não podem ser negativas.");
		}
		this.toneladasAno = toneladasAno;
		calculaTributacao();
		descontoTributacao();
		if (!verificaSeExiste(nomeContribuinte, numeroContribuinte)) {
			caminhoneiros.add(this);
			numeroDeContribuintes++;
		}
	}

		/**
	 * Retorna true se o nome e numero de contribuinte forem iguais.
	 */
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof Caminhoneiros)) {
			return false;
		}
		Caminhoneiros outroCaminhoneiro = (Caminhoneiros) obj;
		return outroCaminhoneiro.getNomeContribuinte().equals(getNomeContribuinte()) && outroCaminhoneiro.getNumeroContribuinte().equals(getNumeroContribuinte());
	}
	
	private boolean verificaSeENegativo (double numero) {
		if (numero < 0) {
			return true;
		}
		return false;
	}
	
	private boolean verificaSeExiste (String nome, String numero) {
		for (Caminhoneiros a: caminhoneiros) {
			if (a.getNomeContribuinte().equals(nome) || a.getNumeroContribuinte().equals(numero)) {
				return true;
			}
		}
		return false;
	}
        @Override
	protected void calculaTributacao() {
		if (toneladasAno <= 10) this.tributacao = IMPOSTO_FIXO;
		else this.tributacao = IMPOSTO_FIXO + (toneladasAno - 10) * 100;
	}
	
	
	private static void atualizaLimiarRiqueza () {
		somaRiquezasCam = 0.0;
		limiarRiquezaCam = 0.0;
		for (Caminhoneiros a: caminhoneiros) {
			somaRiquezasCam += (a.sinaisRiqueza);
		}
		limiarRiquezaCam = (somaRiquezasCam / caminhoneiros.size()) * 1.5;
	}
	
	/**
	 * Atualiza a lista de caminhoneiros e consequentemente o limiar de riqueza
	 * destes. Caso ele esteja acima do limiar, sera atribuido um boolean true a ele.
	 * Caso contrario, sera atribuido um boolean false.
	 */
	public static void atualizaContribuintesLimiarRiqueza () {
		atualizaLimiarRiqueza();
		for (Caminhoneiros a: caminhoneiros) {
			if (a.sinaisRiqueza >= limiarRiquezaCam) {
				a.setRiquezaExcessiva(true);
			}
		}
	}
	
	/**
	 * 
	 * @return O numero de caminhoneiros cadastrados.
	 */
        
	public static int getNumeroDeCaminhoneiros () {
		return caminhoneiros.size();
	}
	
	/**
	 * 
	 * @return A lista estatica da classe contendo os objetos.
	 */
        
	public static List<Caminhoneiros> getCaminhoneiros () {
		return caminhoneiros;
	}
	
	/**
	 * 
	 * @return O limiar de riqueza da classe.
	 */
        
	public static double getLimiarRiqueza () {
		return limiarRiquezaCam;
	}
	
	/**
	 * Efetua uma consulta na lista de caminhoneiros e verifica se ha um contribuinte
	 * com os parametros passados.
	 * @param nome Nome de contribuinte
	 * @param numeroContr Numero de contribuinte
	 * @return Uma string contendo os dados do contribuinte, caso seja encontrado.
	 * Caso contrario retorna uma String contendo "Pessoa nao encontrada."
	 */
        
	public static String consultaContribuinte (String nome, String numeroContr) {
		for (Caminhoneiros a: caminhoneiros) {
			if (nome.equals(a.getNomeContribuinte()) && numeroContr.equals(a.getNumeroContribuinte())) {
				return "Nome: " + a.getNomeContribuinte() + " - Número de contribuinte: " + a.getNumeroContribuinte() +
						"\nTributação bruta: R$ " + a.getTributacao() + "\nDescontos: R$ " + a.getDescontos() + "\nTributação Total: R$ " + a.getTributacaoTotal() + "\n";
			}
		}
		return "Pessoa não encontrada.";
	}
}
