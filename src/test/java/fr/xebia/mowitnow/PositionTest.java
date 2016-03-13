package fr.xebia.mowitnow;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static com.googlecode.catchexception.CatchException.*;

/**
 * Classe test de la classe Position.
 *
 * @author Minh-Trieu HA
 */
public class PositionTest {

    /**
     * Test de la méthode ajouterPosition.
     */
    @Test
    public void testAjouterPosition() {
        Position position = new Position(4, 3);
        Position positionAjouterNul = new Position(0, 0);
        Position positionAjouterNegatif = new Position(-5, -7);
        Position positionAjouterPositif = new Position(14, 50);
        verifyException(position, IllegalArgumentException.class).ajouterPosition(null);

        position.ajouterPosition(positionAjouterNul);
        assertEquals(position.getCoordonneeX(), 4);
        assertEquals(position.getCoordonneeY(), 3);

        position.ajouterPosition(positionAjouterNegatif);

        assertEquals(position.getCoordonneeX(), -1);
        assertEquals(position.getCoordonneeY(), -4);

        position.ajouterPosition(positionAjouterPositif);

        assertEquals(position.getCoordonneeX(), 13);
        assertEquals(position.getCoordonneeY(), 46);
    }


}
