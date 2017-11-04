package Ensino;
/**
 *
 * @author andecio
 */
public class TestaContaSimples1 {
    
	private ContaSimples1 umaConta;

	@Before
	public void criaConta() {
		umaConta = new ContaSimples1("Jacques Sauve", "123456789-01", 123);
	}

	@Test
	public void testaContaSimples1() {
		assertEquals("Nome errado", "JacquesSauve", umaConta.getNome());
		assertEquals("cpf errado", "123456789-01", umaConta.getCPF());
		assertEquals("Número errado", 123, umaConta.getNumero());
		assertEquals("Saldo errado", 0.0, umaConta.getSaldo(), 0.005);
		umaConta.depositar(100.0);
		assertEquals("Saldo errado", 100.0, umaConta.getSaldo(), 0.005);
		assertTrue("Nao consegui sacar", umaConta.sacar(45.0));
		assertEquals("Saldo errado", 55.0, umaConta.getSaldo(), 0.005);
		assertFalse("Consegui sacar demais", umaConta.sacar(56.0));
		assertEquals("Saldo errado", 55.0, umaConta.getSaldo(), 0.005);
	}
}