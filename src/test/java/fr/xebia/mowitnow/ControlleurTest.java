package fr.xebia.mowitnow;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.verifyException;
import static org.junit.Assert.assertEquals;

/**
 * Classe test de la classe Controlleur.
 *
 * @author Minh-Trieu HA
 */
public class ControlleurTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    /**
     * Test de la lecture du paramètre en entrée avec paramètre null.
     */
    @Test
    public void convertirParametreProgrammeNullEnListe() throws IOException {
        thrown.expect( IllegalArgumentException.class );
        thrown.expectMessage("Paramètre programme invalide.");
        Controlleur.convertirParametreProgrammeEnList(null);
    }

    /**
     * Test de la lecture du paramètre en entrée avec paramètre vide.
     */
    @Test
    public void convertirParametreProgrammeVideEnListe() throws IOException {
        String parametreProgrammeVide = "";
        thrown.expect( IllegalArgumentException.class );
        thrown.expectMessage("Paramètre programme invalide.");
        Controlleur.convertirParametreProgrammeEnList(parametreProgrammeVide);

    }

    /**
     * Test de la lecture du paramètre en entrée avec paramètre correcte.
     */
    @Test
    public void convertirParametreProgrammeIncorrectEnListe() throws IOException {
        String parametreProgrammeCorrect = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA";
        ArrayList<String> listeLigneParametre = new ArrayList<>(Arrays.asList("5 5", "1 2 N","GAGAGAGAA", "3 3 E", "AADAADADDA"));
        assertEquals(listeLigneParametre, Controlleur.convertirParametreProgrammeEnList(parametreProgrammeCorrect));
        String parametreProgrammeIncorrecteDimensionTerrain = "Z 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA";
        String parametreProgrammeCorrectFichier = "C:\\Users\\Shad\\IdeaProjects\\MowItNow\\src\\main\\resources\\Configuration.txt";
        String parametreProgrammeIncorrecteInstruction = "Z 5\n1 2 N\nGAZAGAGAA\n3 3 E\nAADAADADDA";
    }

    /**
     * Test de l'initialisation avec un terrain null.
     */
    @Test
    public void initialisationTerrainNull() throws  ConfigurationException {
        thrown.expect(IllegalArgumentException.class );
        thrown.expectMessage("Configuration eronnée.");
            Controlleur.initialisationTerrain(null);
    }

    /**
     * Test de l'initialisation avec un terrain vide.
     */
    @Test
    public void initialisationTerrainVide() throws  ConfigurationException {
        ArrayList<String> terrainVide = new ArrayList<>();
        thrown.expect(ConfigurationException.class );
        thrown.expectMessage("Le fichier est vide.");
        Controlleur.initialisationTerrain(terrainVide);
    }

    /**
     * Test de l'initialisation avec un terrain vide.
     */
    @Test
    public void miseEnMarcheTondeuseNull() throws  IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class );
        thrown.expectMessage("Terrain invalide.");
        Controlleur.miseEnMarcheTondeuse(null);
    }
}
