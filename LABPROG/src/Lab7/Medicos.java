/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab7;
import java.util.ArrayList;
import java.util.List;
public class Medicos extends Contribuintes {
	private int pacientes;
	private double gastosCongressos;
	private static double somaRiquezasMed;
	private static double limiarRiquezaMed;
	private static List<Medicos> medicos = new ArrayList<Medicos>();
        
        /**
	 * Constroi um contribuinte medico a partir dos parametros passados.
	 * @param nomeContribuinte O nome do contribuinte.
	 * @param numeroContribuinte O numero de cadastro do contribuinte.
	 * @param pacientes O numero de pacientes atendidos em um ano.
	 * @param gastos Os gastos efetivados em congressos.
	 * @param valorCarro O valor do carro, se possuir.
	 * @param valorCasa O valor da casa, se possuir.
	 * @throws Exception Caso algum dos valores passados sejam negativos ou
	 * strings vazias.
	 */
        
	public Medicos(String nomeContribuinte, String numeroContribuinte, int pacientes, double gastos, double valorCarro, double valorCasa) throws Exception {
		super(nomeContribuinte, numeroContribuinte, valorCarro, valorCasa);
		if (gastos < 0 || pacientes < 0) throw new Exception("O valor dos gastos e pacientes não podem ser negativos.");
		this.pacientes = pacientes;
		this.gastosCongressos = gastos;
		calculaTributacao();
		descontoTributacao();
		if (!verificaSeExiste(nomeContribuinte, numeroContribuinte)) {
			medicos.add(this);
			numeroDeContribuintes++;
		}
	}

	@Override
	protected void calculaTributacao(){
		tributacao = pacientes * 10;
	}

	@Override
	protected void descontoTributacao(){
		descontos = gastosCongressos;
	}
	
	private boolean verificaSeExiste (String nome, String numero){
		for(Medicos a: medicos){
			if(a.getNomeContribuinte().equals(nome) || a.getNumeroContribuinte().equals(numero)){
				return true;
			}
		}
		return false;
	}
	
	private static void atualizaLimiarRiqueza (){
		somaRiquezasMed = 0.0;
		limiarRiquezaMed = 0.0;
		for (Medicos a: medicos) {
			somaRiquezasMed += (a.sinaisRiqueza);
		}
		limiarRiquezaMed = (somaRiquezasMed / medicos.size()) * 1.5;
	}
	
	/**
	 * 
	 * @return O numero de medicos cadastrados.
	 */
	public static int getNumeroDeMedicos (){
		return medicos.size();
	}
        
	/**
	 * Atualiza a lista de medicos e consequentemente o limiar de riqueza
	 * destes. Caso ele esteja acima do limiar, sera atribuido um boolean true a ele.
	 * Caso contrario, sera atribuido um boolean false.
	 */
        
	public static void atualizaContribuintesLimiarRiqueza () {
		atualizaLimiarRiqueza();
		for (Medicos a: medicos) {
			if (a.sinaisRiqueza >= limiarRiquezaMed) {
				a.setRiquezaExcessiva(true);
			}
		}
	}
        
	/**
	 * 
	 * @return A lista estatica da classe contendo os objetos.
	 */
        
	public static List<Medicos> getMedicos (){
		return medicos;
	}
	
	/**
	 * 
	 * @return O limiar de riqueza da classe.
	 */
        
	public static double getLimiarRiqueza (){
		return limiarRiquezaMed;
	}
	
	/**
	 * Retorna true se o nome e numero de contribuinte forem iguais.
         * @return Falso se nao for, e verdadeiro se for igual
	 */
        
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof Medicos)){
			return false;
		}
		Medicos outroMedico = (Medicos) obj;
		return outroMedico.getNomeContribuinte().equals(getNomeContribuinte()) && outroMedico.getNumeroContribuinte().equals(getNumeroContribuinte());
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.pacientes;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.gastosCongressos) ^ (Double.doubleToLongBits(this.gastosCongressos) >>> 32));
        return hash;
    }
	
	/**
	 * Efetua uma consulta na lista de medicos e verifica se ha um contribuinte
	 * com os parametros passados.
	 * @param nome Nome de contribuinte
	 * @param numeroContr Numero de contribuinte
	 * @return Uma string contendo os dados do contribuinte, caso seja encontrado.
	 * Caso contrario retorna uma String contendo "Pessoa nao encontrada."
	 */
    
	public static String consultaContribuinte (String nome, String numeroContr) {
		for (Medicos a: medicos) {
			if (nome.equals(a.getNomeContribuinte()) && numeroContr.equals(a.getNumeroContribuinte())) {
				return "Nome: " + a.getNomeContribuinte() + " - Número de contribuinte: " + a.getNumeroContribuinte() +
						"\nTributação bruta: R$ " + a.getTributacao() + "\nDescontos: R$ " + a.getDescontos() + "\nTributação Total: R$ " + a.getTributacaoTotal() + "\n";
			}
		}
		return "Pessoa não encontrada.";
	}
}
