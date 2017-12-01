/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab7;
import org.junit.*;
public class TestaProfessores {
    private Professores prof1, prof2, prof3;
	private final int NAO_TEM_CARRO = 0, NAO_TEM_CASA = 0;
	private final double VALOR_PADRAO_CASA = 50000, VALOR_PADRAO_CARRO = 20000, VALOR_ACIMA_CASA = 800000, VALOR_ACIMA_CARRO = 200000;
	private final double DESPESAS1 = 100, DESPESAS2 = 200, DESPESAS3 = 1084.39;
	private final double UM_SALARIO = 912, DOIS_SALARIOS = 1824, SEIS_SALARIOS = 5472;
	
	@Before
	public void criaObjetos () throws Exception {
		prof1 = new Professores("Daniel", "12345", UM_SALARIO, DESPESAS1, VALOR_ACIMA_CARRO, VALOR_ACIMA_CASA);
		prof2 = new Professores("Kelvin", "12934", DOIS_SALARIOS, DESPESAS2, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
		prof3 = new Professores("Andécio", "24560", SEIS_SALARIOS, DESPESAS3, NAO_TEM_CARRO, NAO_TEM_CASA);
	}
	
	@Test
	public void testaConstrutor () throws Exception{
		try {
			new Professores("Andécio", "1234", -1, DESPESAS1, NAO_TEM_CARRO, NAO_TEM_CASA);
			Assert.fail("Deve lançar exceção porque os valores de salário e despesas não podem ser negativos.");
		} catch (Exception e) {
			Assert.assertEquals("Os valores não podem ser negativos.", e.getMessage());
		}
		
		try {
			new Professores("Andécio", "1234", UM_SALARIO, -1, NAO_TEM_CARRO, NAO_TEM_CASA);
			Assert.fail("Deve lançar exceção porque os valores de salário e despesas não podem ser negativos.");
		} catch (Exception e) {
			Assert.assertEquals("Os valores não podem ser negativos.", e.getMessage());
		}
		
		Assert.assertEquals(UM_SALARIO, prof1.getSalario(), 0.01);
		Assert.assertEquals(DOIS_SALARIOS, prof2.getSalario(), 0.01);
		Assert.assertEquals(SEIS_SALARIOS, prof3.getSalario(), 0.01);
		Assert.assertEquals(DESPESAS1, prof1.getDespesas(), 0.01);
		Assert.assertEquals(DESPESAS2, prof2.getDespesas(), 0.01);
		Assert.assertEquals(DESPESAS3, prof3.getDespesas(), 0.01);
		
	}
	
	@Test
	public void testaCalculaTributacao (){
		Assert.assertEquals(91.2, prof1.getTributacao(), 0.01);
		Assert.assertEquals(182.40, prof2.getTributacao(), 0.01);
		Assert.assertEquals(1094.4, prof3.getTributacao(), 0.01);
	}
	
	@Test
	public void testaDescontoTributacao (){
		Assert.assertEquals(50, prof1.getDescontos(), 1);
		Assert.assertEquals(100, prof2.getDescontos(), 1);
		Assert.assertEquals(542.19, prof3.getDescontos(), 0.01);
	}
	
	@Test
	public void testaTributacaoTotal (){
		Assert.assertEquals(41.2, prof1.getTributacaoTotal(), 1);
		Assert.assertEquals(82.4, prof2.getTributacaoTotal(), 1);
		Assert.assertEquals(552.205, prof3.getTributacaoTotal(), 0.01);
	}
	
	@Test
	public void testaLimiarRiqueza () throws Exception{
		Professores.atualizaContribuintesLimiarRiqueza();
		Assert.assertTrue(Professores.getProfessores().get(0).getAcimaDaLimiar());
		Assert.assertFalse(Professores.getProfessores().get(1).getAcimaDaLimiar());
		Assert.assertFalse(Professores.getProfessores().get(2).getAcimaDaLimiar());
		}
	
	@Test
	public void testaToString (){
		Assert.assertEquals("Nome: Daniel - Número de contribuinte: 12345", prof1.toString());
		Assert.assertEquals("Nome: Kelvin - Número de contribuinte: 12934", prof2.toString());
		Assert.assertEquals("Nome: Andécio - Número de contribuinte: 24560", prof3.toString());
	}
	
	@Test
	public void testaEquals () throws Exception{
		Taxistas taxi = new Taxistas("Teste", "1234", 20, 20, NAO_TEM_CARRO, NAO_TEM_CASA);
		Assert.assertFalse(prof1.equals(taxi));
		Assert.assertFalse(prof1.equals(prof2));
		Assert.assertFalse(prof2.equals(prof3));
		prof1 = new Professores("Kelvin", "12934", DOIS_SALARIOS, DESPESAS2, VALOR_PADRAO_CARRO, VALOR_PADRAO_CASA);
		Assert.assertTrue(prof1.equals(prof2));
	}
	
}
