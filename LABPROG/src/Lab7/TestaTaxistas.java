/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab7;
import org.junit.*;

/**
 *
 * @author Andécio
 */
public class TestaTaxistas {
    private Taxistas taxi1, taxi2, taxi3;
	private final int NAO_TEM_CARRO = 0, NAO_TEM_CASA = 0;
	private final double VALOR_PADRAO_CASA = 50000, VALOR_PADRAO_CARRO = 20000, VALOR_ACIMA_CASA = 800000, VALOR_ACIMA_CARRO = 200000;
	private final double QUILOMETROS_PERCORRIDOS = 15000;
	private final double QUILOMETROS_PERCORRIDOS2 = 73200.29;
	private final double QUILOMETROS_PERCORRIDOS3 = 8750.31;
	private final int PASSAGEIROS_1 = 1200;
	private final int PASSAGEIROS_2 = 900;
	private final int PASSAGEIROS_3 = 700;
	
    /**
     *
     * @throws Exception
     */
    @Before
	public void criaObjetos () throws Exception {
		taxi1 = new Taxistas("Roberval", "2125-4", QUILOMETROS_PERCORRIDOS, PASSAGEIROS_1, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
		taxi2 = new Taxistas("Kleyton", "2125-8", QUILOMETROS_PERCORRIDOS2, PASSAGEIROS_2, VALOR_ACIMA_CARRO, VALOR_ACIMA_CASA);
		taxi3 = new Taxistas("Morais", "2126-3", QUILOMETROS_PERCORRIDOS3, PASSAGEIROS_3, NAO_TEM_CARRO, NAO_TEM_CASA);
	}
	
    /**
     *
     * @throws Exception
     */
    @Test
	public void testaConstrutor () throws Exception {
		try {
			new Taxistas("", "2125-4", QUILOMETROS_PERCORRIDOS, PASSAGEIROS_1, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
			Assert.fail("Deve lançar exceção porque o nome não deve ser uma String vazia.");
		} catch (Exception e) {
			Assert.assertEquals("O nome não pode ser vazio ou null, nem o número de cadastro.", e.getMessage());
		}
		
		try {
			new Taxistas(null, "2125-4", QUILOMETROS_PERCORRIDOS, PASSAGEIROS_1, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
			Assert.fail("Deve lançar exceção porque o nome não deve ser uma String vazia.");
		} catch (Exception e) {
			Assert.assertEquals("O nome não pode ser vazio ou null, nem o número de cadastro.", e.getMessage());
		}
		
		try {
			new Taxistas("Roberval", "", QUILOMETROS_PERCORRIDOS, PASSAGEIROS_1, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
			Assert.fail("Deve lançar exceção porque o nome não deve ser uma String vazia.");
		} catch (Exception e) {
			Assert.assertEquals("O nome não pode ser vazio ou null, nem o número de cadastro.", e.getMessage());
		}
		
		try {
			new Taxistas("Roberval", null, QUILOMETROS_PERCORRIDOS, PASSAGEIROS_1, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
			Assert.fail("Deve lançar exceção porque o nome não deve ser uma String vazia.");
		} catch (Exception e) {
			Assert.assertEquals("O nome não pode ser vazio ou null, nem o número de cadastro.", e.getMessage());
		}
		
		try {
			new Taxistas("Roberval", "2125-4", -10, PASSAGEIROS_1, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
			Assert.fail("Deve lançar exceção porque o nome não deve ser uma String vazia.");
		} catch (Exception e) {
			Assert.assertEquals("Os quilômetros percorridos não podem ser negativos.", e.getMessage());
		}
		
		try {
			new Taxistas("Roberval", "2125-4", QUILOMETROS_PERCORRIDOS, -10, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
			Assert.fail("Deve lançar exceção porque o nome não deve ser uma String vazia.");
		} catch (Exception e) {
			Assert.assertEquals("O número de passageiros não pode ser negativo.", e.getMessage());
		}
		
		Assert.assertEquals("Roberval", taxi1.getNomeContribuinte());
		Assert.assertEquals("Kleyton", taxi2.getNomeContribuinte());
		Assert.assertEquals("Morais", taxi3.getNomeContribuinte());
		Assert.assertEquals("2125-4", taxi1.getNumeroContribuinte());
		Assert.assertEquals("2125-8", taxi2.getNumeroContribuinte());
		Assert.assertEquals("2126-3", taxi3.getNumeroContribuinte());
		Assert.assertEquals(PASSAGEIROS_1, taxi1.getPassageiros());
		Assert.assertEquals(PASSAGEIROS_2, taxi2.getPassageiros());
		Assert.assertEquals(PASSAGEIROS_3, taxi3.getPassageiros());
		Assert.assertEquals(3, Taxistas.getNumeroDeTaxistas());
	}
	
    /**
     *
     */
    @Test
	public void testaCalculaTributacao () {
		Assert.assertEquals(600, taxi1.getTributacao(), 1);
		Assert.assertEquals(450, taxi2.getTributacao(), 1);
		Assert.assertEquals(350, taxi3.getTributacao(), 1);
	}
	
    /**
     *
     */
    @Test
	public void testaDescontoTributacao () {
		Assert.assertEquals(150, taxi1.getDescontos(), 1);
		Assert.assertEquals(732, taxi2.getDescontos(), 0.01);
		Assert.assertEquals(87.50, taxi3.getDescontos(), 0.01);
	}
	
    /**
     *
     */
    @Test
	public void testaTributacaoTotal () {
		Assert.assertEquals(450, taxi1.getTributacaoTotal(), 1);
		Assert.assertEquals(0, taxi2.getTributacaoTotal(), 0.01);
		Assert.assertEquals(262.50, taxi3.getTributacaoTotal(), 0.01);
	}
	
    /**
     *
     * @throws Exception
     */
    @Test
	public void testaLimiarRiqueza () throws Exception {
		Taxistas.atualizaContribuintesLimiarRiqueza();
		Assert.assertFalse(Taxistas.getTaxistas().get(0).getAcimaDaLimiar());
		Assert.assertTrue(Taxistas.getTaxistas().get(1).getAcimaDaLimiar());
		Assert.assertFalse(Taxistas.getTaxistas().get(2).getAcimaDaLimiar());
		}
	
    /**
     *
     */
    @Test
	public void testaToString () {
		Assert.assertEquals("Nome: Roberval - Número de contribuinte: 2125-4", taxi1.toString());
		Assert.assertEquals("Nome: Kleyton - Número de contribuinte: 2125-8", taxi2.toString());
		Assert.assertEquals("Nome: Morais - Número de contribuinte: 2126-3", taxi3.toString());
	}
	
    /**
     *
     * @throws Exception
     */
    @Test
	public void testaEquals () throws Exception {
		Caminhoneiros cam1 = new Caminhoneiros("Ricardo", "123-4", 20, QUILOMETROS_PERCORRIDOS, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
		Assert.assertFalse(taxi1.equals(cam1));
		Assert.assertFalse(taxi1.equals(taxi2));
		Assert.assertFalse(taxi2.equals(taxi3));
		taxi1 = new Taxistas("Roberval", "2125-8", QUILOMETROS_PERCORRIDOS2, PASSAGEIROS_2, VALOR_ACIMA_CARRO, VALOR_ACIMA_CASA);
		Assert.assertTrue(taxi1.equals(taxi2));
	}
}

