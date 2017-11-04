package Ensino;
/**
 *
 * @author andecio
 */
public class Exemplo1 {
    // O programa sempre tem um "método" main que é onde começa a execução
	public static void main(String args[]) {
		// Abra uma conta de número 1 para João com CPF 309140605-06
		// A conta será "referenciada" com a variável umaConta
		ContaSimples1 umaConta = new ContaSimples1("Joao", "30914060506", 1);
		// Nesta conta, deposite R$1000,00
		umaConta.depositar(1000.0);
		
		// Imprima o saldo da conta de João
		double saldo = umaConta.getSaldo();
		System.out.print("Saldo da conta de Joao antes do saque: ");
		System.out.println(saldo);
		
		// Saque R$300,00 desta conta
		umaConta.sacar(300.0);
		// Imprima o objeto umaConta
		System.out.println(umaConta.toString());
		// Imprima o saldo da conta de João
		System.out.println("Saldo da conta de Joao depois do saque: "
				+ umaConta.getSaldo());
		
		/*
		System.out.println("Numero de contas no banco: " + umaConta.getTotalContas());
		
		ContaSimples1 outraConta = new ContaSimples1("Daniel", "418648464", 2);
		System.out.println("Numero de contas no banco: " + outraConta.getTotalContas());
		
		ContaSimples1 anotherConta = new ContaSimples1("Emilia", "359513", 3);
		System.out.println("Numero de contas no banco: " + anotherConta.getTotalContas());

		ContaSimples1 maisUmaConta = new ContaSimples1("Jose", "4145814584", 4);
		System.out.println("Numero de contas no banco: " + maisUmaConta.getTotalContas());
		
		System.out.println("Numero de contas no banco pelo objeto umaConta: " + umaConta.getTotalContas());
		*/
		
	} // fim do método main
} // fim da classe Exemplo1
