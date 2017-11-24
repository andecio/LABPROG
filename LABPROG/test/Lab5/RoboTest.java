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
public class RoboTest {
    
    public RoboTest() {
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
     * Test of getPosicao method, of class Robo.
     */
    @Test
    public void testGetPosicao() {
        System.out.println("getPosicao");
        Robo instance = null;
        int[] expResult = null;
        int[] result = instance.getPosicao();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnergia method, of class Robo.
     */
    @Test
    public void testGetEnergia() {
        System.out.println("getEnergia");
        Robo instance = null;
        int expResult = 0;
        int result = instance.getEnergia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassos method, of class Robo.
     */
    @Test
    public void testGetPassos() {
        System.out.println("getPassos");
        Robo instance = null;
        int expResult = 0;
        int result = instance.getPassos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalaDoRobo method, of class Robo.
     */
    @Test
    public void testGetSalaDoRobo() {
        System.out.println("getSalaDoRobo");
        Robo instance = null;
        Sala expResult = null;
        Sala result = instance.getSalaDoRobo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andarParaCima method, of class Robo.
     */
    @Test
    public void testAndarParaCima() throws Exception {
        System.out.println("andarParaCima");
        Robo instance = null;
        boolean expResult = false;
        boolean result = instance.andarParaCima();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andarParaBaixo method, of class Robo.
     */
    @Test
    public void testAndarParaBaixo() throws Exception {
        System.out.println("andarParaBaixo");
        Robo instance = null;
        boolean expResult = false;
        boolean result = instance.andarParaBaixo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andarParaEsquerda method, of class Robo.
     */
    @Test
    public void testAndarParaEsquerda() throws Exception {
        System.out.println("andarParaEsquerda");
        Robo instance = null;
        boolean expResult = false;
        boolean result = instance.andarParaEsquerda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andarParaDireita method, of class Robo.
     */
    @Test
    public void testAndarParaDireita() throws Exception {
        System.out.println("andarParaDireita");
        Robo instance = null;
        boolean expResult = false;
        boolean result = instance.andarParaDireita();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Robo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Robo outroRobo = null;
        Robo instance = null;
        boolean expResult = false;
        boolean result = instance.equals(outroRobo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
