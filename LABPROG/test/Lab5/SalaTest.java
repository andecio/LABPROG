/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andecio
 */
public class SalaTest {
    
    public SalaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNumPosicoesHorizontais method, of class Sala.
     */
    @Test
    public void testGetNumPosicoesHorizontais() {
        System.out.println("getNumPosicoesHorizontais");
        Sala instance = null;
        int expResult = 0;
        int result = instance.getNumPosicoesHorizontais();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumPosicoesVerticais method, of class Sala.
     */
    @Test
    public void testGetNumPosicoesVerticais() {
        System.out.println("getNumPosicoesVerticais");
        Sala instance = null;
        int expResult = 0;
        int result = instance.getNumPosicoesVerticais();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSala method, of class Sala.
     */
    @Test
    public void testGetSala() {
        System.out.println("getSala");
        Sala instance = null;
        char[][] expResult = null;
        char[][] result = instance.getSala();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVazia method, of class Sala.
     */
    @Test
    public void testIsVazia() {
        System.out.println("isVazia");
        Sala instance = null;
        boolean expResult = false;
        boolean result = instance.isVazia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserirObstaculo method, of class Sala.
     */
    @Test
    public void testInserirObstaculo() throws Exception {
        System.out.println("inserirObstaculo");
        int linha = 0;
        int coluna = 0;
        Sala instance = null;
        boolean expResult = false;
        boolean result = instance.inserirObstaculo(linha, coluna);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of posicaoValida method, of class Sala.
     */
    @Test
    public void testPosicaoValida() {
        System.out.println("posicaoValida");
        int linha = 0;
        int coluna = 0;
        Sala instance = null;
        boolean expResult = false;
        boolean result = instance.posicaoValida(linha, coluna);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPosicaoLivre method, of class Sala.
     */
    @Test
    public void testIsPosicaoLivre() throws Exception {
        System.out.println("isPosicaoLivre");
        int linha = 0;
        int coluna = 0;
        Sala instance = null;
        boolean expResult = false;
        boolean result = instance.isPosicaoLivre(linha, coluna);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicao method, of class Sala.
     */
    @Test
    public void testSetPosicao() {
        System.out.println("setPosicao");
        int linha = 0;
        int coluna = 0;
        char statusPosicao = ' ';
        Sala instance = null;
        boolean expResult = false;
        boolean result = instance.setPosicao(linha, coluna, statusPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Sala.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Sala outraSala = null;
        Sala instance = null;
        boolean expResult = false;
        boolean result = instance.equals(outraSala);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
