package Ensino;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
/**
 *
 * @author andecio
 */
public class TesteContaSimples2 {
    private ContaSimples2 umaConta;

	@Before
	public void criaConta() throws Exception {
		umaConta = new ContaSimples2("Jacques Sauve", "123456789-01", 123);
	}

	@Test
	public void testaContaSimples1() throws Exception {
		Assert.assertEquals("Nome errado", "Jacques Sauve", umaConta.getNome());
		Assert.assertEquals("cpf errado", "123456789-01", umaConta.getCPF());
		Assert.assertEquals("Número errado", 123, umaConta.getNumero());
		Assert.assertEquals("Saldo errado", 0.0, umaConta.getSaldo(), 0.005);
		umaConta.depositar(100.0);
		Assert.assertEquals("Saldo errado", 100.0, umaConta.getSaldo(), 0.005);
		Assert.assertTrue("Nao consegui sacar", umaConta.sacar(45.0));
		Assert.assertEquals("Saldo errado", 55.0, umaConta.getSaldo(), 0.005);
		Assert.assertFalse("Consegui sacar demais", umaConta.sacar(56.0));
		Assert.assertEquals("Saldo errado", 55.0, umaConta.getSaldo(), 0.005);
	}

	@Test
	public void testaErrosNoConstrutor() {
		try {
			ContaSimples2 umaConta = new ContaSimples2("", "123456789-01", 123);
			Assert.fail("Esperava excecao de nome vazio");
		} catch (Exception ex) {
			Assert.assertEquals("Mensagem errada",
					"Nome nao pode ser nulo ou vazio", ex.getMessage());
		}
		try {
			ContaSimples2 umaConta = new ContaSimples2(null, "123456789-01",
					123);
			Assert.fail("Esperava excecao de nome nulo");
		} catch (Exception ex) {
			Assert.assertEquals("Mensagem errada",
					"Nome nao pode ser nulo ou vazio", ex.getMessage());
		}
		try {
			ContaSimples2 umaConta = new ContaSimples2("Jacques Sauve", "", 123);
			Assert.fail("Esperava excecao de CPF vazio");
		} catch (Exception ex) {
			Assert.assertEquals("Mensagem errada",
					"CPF nao pode ser nulo ou vazio", ex.getMessage());
		}
		try {
			ContaSimples2 umaConta = new ContaSimples2("Jacques Sauve", null,
					123);
			Assert.fail("Esperava excecao de CPF nulo");
		} catch (Exception ex) {
			Assert.assertEquals("Mensagem errada",
					"CPF nao pode ser nulo ou vazio", ex.getMessage());
		}
		try {
			ContaSimples2 umaConta = new ContaSimples2("Jacques Sauve",
					"123456789-01", 0);
			Assert.fail("Esperava excecao de numero de conta errada");
		} catch (Exception ex) {
			Assert.assertEquals("Mensagem errada",
					"Número da conta deve ser positivo", ex.getMessage());
		}
		try {
			ContaSimples2 umaConta = new ContaSimples2("Jacques Sauve",
					"123456789-01", -1);
			Assert.fail("Esperava excecao de numero de conta errada");
		} catch (Exception ex) {
			Assert.assertEquals("Mensagem errada",
					"Número da conta deve ser positivo", ex.getMessage());
		}
	}

	@Test
	public void testaDepositar() throws Exception {
		Assert.assertEquals("Saldo errado", 0.0, umaConta.getSaldo(), 0.005);
		umaConta.depositar(100.0);
		Assert.assertEquals("Saldo errado", 100.0, umaConta.getSaldo(), 0.005);
		umaConta.depositar(0.0);
		Assert.assertEquals("Saldo errado", 100.0, umaConta.getSaldo(), 0.005);
		try {
			umaConta.depositar(-0.01);
			Assert.fail("Esperava excecao no deposito");
		} catch (Exception ex) {
			Assert.assertEquals("Mensagem errada",
					"Deposito nao pode ser negativo", ex.getMessage());
		}
		umaConta.depositar(0.01);
		Assert.assertEquals("Saldo errado", 100.01, umaConta.getSaldo(), 0.005);
	}

	@Test
	public void testaSacar() throws Exception {
		Assert.assertEquals("Saldo errado", 0.0, umaConta.getSaldo(), 0.005);
		Assert.assertTrue("Nao consegui sacar", umaConta.sacar(0.0));
		Assert.assertEquals("Saldo errado", 0.0, umaConta.getSaldo(), 0.005);
		umaConta.depositar(100.0);
		Assert.assertTrue("Nao consegui sacar", umaConta.sacar(23.10));
		Assert.assertEquals("Saldo errado", 76.90, umaConta.getSaldo(), 0.005);
		Assert.assertFalse("Consegui sacar demais", umaConta.sacar(76.91));
		Assert.assertTrue("Nao consegui sacar", umaConta.sacar(76.90));
		Assert.assertEquals("Saldo errado", 0.0, umaConta.getSaldo(), 0.005);
		try {
			umaConta.sacar(-0.01);
			Assert.fail("Esperava excecao no saque");
		} catch (Exception ex) {
			Assert.assertEquals("Mensagem errada",
					"Saque nao pode ser negativo", ex.getMessage());
		}
		Assert.assertEquals("Saldo errado", 0.0, umaConta.getSaldo(), 0.005);
	}

	@Test
	public void testaToString() throws Exception {
		Assert.assertEquals("toString errado",
				"numero 123, nome Jacques Sauve, saldo 0.0", umaConta
						.toString());
		umaConta.depositar(1.23);
		Assert.assertEquals("toString errado",
				"numero 123, nome Jacques Sauve, saldo 1.23", umaConta
						.toString());
	}
}