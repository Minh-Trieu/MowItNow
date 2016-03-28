package fr.xebia.mowitnow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Classe test de la classe Orientation.
 *
 * @author Minh-Trieu HA
 */
public class OrientationTest {

    /**
     * Test de la méthode testRecupererOrientationADroite.
     */
    @Test
    public void testRecupererOrientationAGauche() {
        Orientation orientation = Orientation.N;
        orientation = orientation.recupererOrientationAGauche();
        assertEquals(orientation, Orientation.W);
        orientation = orientation.recupererOrientationAGauche();
        assertEquals(orientation, Orientation.S);
        orientation = orientation.recupererOrientationAGauche();
        assertEquals(orientation, Orientation.E);
    }

    /**
     * Test de la méthode testRecupererOrientationAGauche.
     */
    @Test
    public void testRecupererOrientationADroite() {
        Orientation orientation = Orientation.N;
        orientation = orientation.recupererOrientationADroite();
        assertEquals(orientation, Orientation.E);
        orientation = orientation.recupererOrientationADroite();
        assertEquals(orientation, Orientation.S);
        orientation = orientation.recupererOrientationADroite();
        assertEquals(orientation, Orientation.W);
    }

}
