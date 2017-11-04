package Ensino;
/**
 *
 * @author andecio
 */
public class ContaSimples1 {
private String nome;
	private String cpf;
	private int numero;
	private double saldo;
	
	private static int totalDeContas;

	// construtor
	/**
	 * Cria uma conta a partir de um nome e cpf de pessoa física, e um número
	 * de conta.

	 * @param nome
	 *            O nome do titular da conta.
	 * @param cpf
	 *            O CPF do titular da conta.
	 * @param numero
	 *            O número da conta.
	 */

	public ContaSimples1(String nome, String cpf, int numero) {
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;
		saldo = 0.0;
		totalDeContas++;
	}
	
	public int getTotalContas() {
		return totalDeContas;
	}

	// métodos

	/**
	 * Recupera o nome do titular da conta.
	 *
	 * @return O nome do titular da conta.
	 */

	public String getNome() {
		return nome;
	}

	/**
	 * Recupera o CPF do titular da conta.
	 * 
	 * @return O CPF do titular da conta.
	 */

	public String getCPF() {
		return cpf;
	}

	/**
	 * Recupera o número da conta.
	 * 
	 * @return O número da conta.
	 */

	public int getNumero() {
		return numero;
	}

	/**
	 * Recupera o saldo da conta.
	 * 
	 * @return O saldo da conta.
	 */

	public double getSaldo() {
		return saldo;
	}

	/**
	 * Efetua um depósito numa conta.
	 *
	 * @param valor
	 *            O valor a depositar.
	 */

	public void depositar(double valor) {
		saldo += valor;
	}

	/**
	 * Efetua sacada na conta.
	 * 
	 * @param valor
	 *            O valor a sacar.
	 * @return O sucesso ou não da operação.
	 */

	public boolean sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			return true;
		}
		return false;
	}

	/**
	 * Transforma os dados da conta em um String.
	 * 
	 * @return O string com os dados da conta.
	 */

	public String toString() {
		return "numero " + numero + ", nome " + nome + ", saldo " + saldo;
	}
}