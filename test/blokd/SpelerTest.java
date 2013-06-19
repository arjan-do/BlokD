/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd;

import java.awt.Graphics2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tony
 */
public class SpelerTest {
    
    public SpelerTest() {
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
     * Test of getScore method, of class Speler.
     */
    /*@Test
    public void testGetScore() {
        System.out.println("getScore");
        Speler instance = new Speler();
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setScore method, of class Speler.
     */
    /*@Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 0;
        Speler instance = new Speler();
        instance.setScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of addScore method, of class Speler.
     */
    /*@Test
    public void testAddScore() {
        System.out.println("addScore");
        int score = 0;
        Speler instance = new Speler();
        instance.addScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of removeScore method, of class Speler.
     */
    /*@Test
    public void testRemoveScore() {
        System.out.println("removeScore");
        int score = 0;
        Speler instance = new Speler();
        instance.removeScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of draw method, of class Speler.
     */
    /*@Test
    public void testDraw() {
        System.out.println("draw");
        Graphics2D g = null;
        int x = 0;
        int y = 0;
        Speler instance = new Speler();
        instance.draw(g, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of beweeg method, of class Speler.
     */
    @Test
    public void testBeweeg() {
        System.out.println("beweeg");
        Speelveld speelveld = new Speelveld();
        speelveld.startvakje = MazeGenerator.testBeweeg(35, 65);
        Direction direction = Direction.RIGHT;
        Speler instance = (Speler)speelveld.startvakje.bevat;
        instance.beweeg(direction);
        System.out.println("ID beginvakje: " + speelveld.startvakje.id);
        System.out.println("ID vakje na lopen: " + instance.huidigvakje.id);
    }
    /**
     * Test of filling the inventory, of class Speler.
     */
    @Test
    public void testInventory() {
        System.out.println("inventory");
        Speelveld speelveld = new Speelveld();
        speelveld.startvakje = MazeGenerator.testInventory(35, 65);
        Speler instance = (Speler)speelveld.startvakje.bevat;
        System.out.println("Inhoud inventory voor oppakken: " + instance.inventory.toString());
        Direction direction = Direction.RIGHT;
        instance.beweeg(direction);
        System.out.println("Inhoud inventory na oppakken: " + instance.inventory.toString());
    }
    /**
     * Test of gebruikitem method, of class Speler.
     */
    /*@Test
    public void testGebruikitem() {
        System.out.println("gebruikitem");
        Speler instance = new Speler();
        instance.gebruikitem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}