/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/

package Lab8;
import org.junit.*;
import java.util.*;

/**
 *
 * @author andecio
 */
public class TestaOpiniao {
    private final String COMENTARIO_VALIDO = "Produto muito eficiente, "
			+ "rápido e simples de ser manuseado sem falar da praticidade.";
	private final String COMENTARIO_INVALIDO = "Achei o produto bastante eficiente, "
			+ "rápido e simples de ser manuseado sem falar da praticidade. Mas, infelizmente, "
			+ "não pude adquirir um produto deste tipo devido ao seu preço. Por favor, "
			+ "diminuam o preço para que pessoas como eu também possam ser incluídas na "
			+ "lista de clientes felizes que possuem tal mercadoria. Abraços, Sonia.";
	private final String STRING_VAZIA = "";
	private Opiniao opiniao1, opiniao2;
	private final int NOTA_PADRAO = 1, NOTA_PADRAO2 = 2;
	private GregorianCalendar data, data2;
	private String TITULO_PRODUTO = "Cachaça Caranguejo";
	
    /**
     *
     * @throws Exception
     */
    @Before
	public void criaObjetos() throws Exception{
		opiniao1 = new Opiniao(NOTA_PADRAO, COMENTARIO_VALIDO);
		opiniao2 = new Opiniao(NOTA_PADRAO2, COMENTARIO_VALIDO);
		data = new GregorianCalendar();
		
		Thread.sleep(2000);
		
		data2 = new GregorianCalendar();
	}
	
    /**
     *
     */
    @Test
	public void testaConstrutor(){
		try {
			new Opiniao(-3, COMENTARIO_VALIDO);
			Assert.fail("Deve lançar exceção: Nota Inválida.");
		} catch (Exception e) {
			Assert.assertEquals("Voce tem que atribuir uma nota entre -2 e 2", e.getMessage());
		}
		
		try {
			new Opiniao(3, COMENTARIO_VALIDO);
			Assert.fail("Deve lançar exceção: Nota Inválida.");
		} catch (Exception e) {
			Assert.assertEquals("Voce tem que atribuir uma nota entre -2 e 2", e.getMessage());
		}
		
		try {
			new Opiniao(2, STRING_VAZIA);
			Assert.fail("Deve lançar exceção: Comentário inválido.");
		} catch (Exception e) {
			Assert.assertEquals("O comentario nao pode ser vazio", e.getMessage());
		}
		
		try {
			new Opiniao(2, null);
			Assert.fail("Deve lançar exceção: Comentário inválido.");
		} catch (Exception e) {
			Assert.assertEquals("O comentario nao pode ser vazio", e.getMessage());
		}
		
		try {
			new Opiniao(2, COMENTARIO_INVALIDO);
			Assert.fail("Deve lançar exceção: Comentário inválido.");
		} catch (Exception e) {
			Assert.assertEquals("No maximo 140 caracteres", e.getMessage());
		}
		
		Assert.assertEquals(NOTA_PADRAO, opiniao1.getNotaProduto());
		Assert.assertEquals(COMENTARIO_VALIDO, opiniao1.getComentario());
		Assert.assertEquals(data.getTime(), opiniao1.getDataDoComentario());
		Assert.assertFalse(data2.getTime() == opiniao1.getDataDoComentario());
		
	}
	
    /**
     *
     */
    @Test
	public void testaToString(){
		Assert.assertEquals("Nota: 1\nComentário: Achei o produto bastante eficiente, rápido e simples de ser manuseado sem falar da praticidade.", opiniao1.toString());
	}
	
    /**
     *
     * @throws Exception
     */
    @Test
	public void testaEquals() throws Exception{
		Produto produto = new Produto(TITULO_PRODUTO);
		Assert.assertFalse(opiniao1.equals(opiniao2));
		Assert.assertFalse(opiniao1.equals(produto));
		opiniao2 = opiniao1;
		Assert.assertTrue(opiniao1.equals(opiniao2));
		
	}
}