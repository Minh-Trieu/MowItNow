package fr.xebia.mowitnow;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static com.googlecode.catchexception.CatchException.*;

/**
 * Classe test de la classe Tondeuse.
 *
 * @author Minh-Trieu HA
 */
public class TondeuseTest {

    private Tondeuse tondeuseCasExemple;
    private Tondeuse tondeuseCasExemple2;
    private Tondeuse tondeuseCasSortieTerrain;
    private Tondeuse tondeuseCasCollisionTondeuse;

    private Terrain terrain;

    /**
     * Initialisation des paramètres nécessaires pour les tests.
     * @throws Exception
     */
    @Before
    public void initialiser() throws Exception {

        terrain = new Terrain(10, 10);

        // Initialisation de la tondeuse correspondant au premier cas d'exemple.
        Position positionTondeuseCasExemple = new Position(1, 2);
        Orientation orientationTondeuseCasExemple = Orientation.N;
        ArrayList<Instruction> instructionsTondeuseCasExemple = new ArrayList<>();
        instructionsTondeuseCasExemple.add(Instruction.G);
        instructionsTondeuseCasExemple.add(Instruction.A);
        instructionsTondeuseCasExemple.add(Instruction.G);
        instructionsTondeuseCasExemple.add(Instruction.A);
        instructionsTondeuseCasExemple.add(Instruction.G);
        instructionsTondeuseCasExemple.add(Instruction.A);
        instructionsTondeuseCasExemple.add(Instruction.G);
        instructionsTondeuseCasExemple.add(Instruction.A);
        instructionsTondeuseCasExemple.add(Instruction.A);
        tondeuseCasExemple = new Tondeuse(positionTondeuseCasExemple, orientationTondeuseCasExemple, instructionsTondeuseCasExemple);

        // Initialisation de la tondeuse correspondant au second cas d'exemple.
        Position positionTondeuseCasExemple2 = new Position(3, 3);
        Orientation orientationTondeuseCasExemple2 = Orientation.E;
        ArrayList<Instruction> instructionsTondeuseCasExemple2 = new ArrayList<>();
        instructionsTondeuseCasExemple2.add(Instruction.A);
        instructionsTondeuseCasExemple2.add(Instruction.A);
        instructionsTondeuseCasExemple2.add(Instruction.D);
        instructionsTondeuseCasExemple2.add(Instruction.A);
        instructionsTondeuseCasExemple2.add(Instruction.A);
        instructionsTondeuseCasExemple2.add(Instruction.D);
        instructionsTondeuseCasExemple2.add(Instruction.A);
        instructionsTondeuseCasExemple2.add(Instruction.D);
        instructionsTondeuseCasExemple2.add(Instruction.D);
        instructionsTondeuseCasExemple2.add(Instruction.A);
        tondeuseCasExemple2 = new Tondeuse(positionTondeuseCasExemple2, orientationTondeuseCasExemple2, instructionsTondeuseCasExemple2);

        // Initialisation de la tondeuse correspondant a un cas de sortie de terrain.
        Position positionTondeuseCasSortieTerrain = new Position(7, 6);
        Orientation orientationTondeuseCasSortieTerrain = Orientation.E;
        ArrayList<Instruction> instructionsTondeuseCasSortieTerrain = new ArrayList<>();
        instructionsTondeuseCasSortieTerrain.add(Instruction.A);
        instructionsTondeuseCasSortieTerrain.add(Instruction.A);
        instructionsTondeuseCasSortieTerrain.add(Instruction.A);
        instructionsTondeuseCasSortieTerrain.add(Instruction.A);
        instructionsTondeuseCasSortieTerrain.add(Instruction.G);
        instructionsTondeuseCasSortieTerrain.add(Instruction.A);
        instructionsTondeuseCasSortieTerrain.add(Instruction.A);
        instructionsTondeuseCasSortieTerrain.add(Instruction.D);
        tondeuseCasSortieTerrain = new Tondeuse(positionTondeuseCasSortieTerrain, orientationTondeuseCasSortieTerrain, instructionsTondeuseCasSortieTerrain);


        // Initialisation de la tondeuse correspondant a un cas de sortie collision.
        Position positionTondeuseCasCollisionTondeuse = new Position(10, 10);
        Orientation orientationCasCollisionTondeuse = Orientation.S;
        ArrayList<Instruction> instructionsTondeuseCasCollisionTondeuse = new ArrayList<>();
        instructionsTondeuseCasCollisionTondeuse.add(Instruction.A);
        instructionsTondeuseCasCollisionTondeuse.add(Instruction.A);
        instructionsTondeuseCasCollisionTondeuse.add(Instruction.D);
        instructionsTondeuseCasCollisionTondeuse.add(Instruction.A);
        instructionsTondeuseCasCollisionTondeuse.add(Instruction.A);
        instructionsTondeuseCasCollisionTondeuse.add(Instruction.A);
        instructionsTondeuseCasCollisionTondeuse.add(Instruction.G);
        instructionsTondeuseCasCollisionTondeuse.add(Instruction.A);
        tondeuseCasCollisionTondeuse = new Tondeuse(positionTondeuseCasCollisionTondeuse, orientationCasCollisionTondeuse, instructionsTondeuseCasCollisionTondeuse);

        terrain.ajouterTondeuse(tondeuseCasExemple);
        terrain.ajouterTondeuse(tondeuseCasExemple2);
        terrain.ajouterTondeuse(tondeuseCasSortieTerrain);
        terrain.ajouterTondeuse(tondeuseCasCollisionTondeuse);
    }

    /**
     *  Nettoyage des paramètres nécessaires pour les tests.
     * @throws Exception
     */
    @After
    public void nettoyer() throws Exception {
        tondeuseCasExemple = null;
        terrain = null;
    }


    /**
     * Test du constructeur avec position null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTondeuseNullPosition() {
        Orientation orientation = Orientation.N;
        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        tondeuseCasExemple = new Tondeuse(null, orientation, instructions);
    }

    /**
     * Test du constructeur avec orientation null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTondeuseNullOrientation() {
        Position position = new Position(1, 2);
        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        tondeuseCasExemple = new Tondeuse(position, null, instructions);
    }

    /**
     * Test du constructeur avec orientation null.
     */
    @Test
    public void testTondeuseNullInstructions() {
        Position position = new Position(1, 2);
        Orientation orientation = Orientation.N;
        tondeuseCasExemple = new Tondeuse(position, orientation, null);
    }

    /**
     * Test de la méthode d'exécutions des instructions.
     */
    @Test
    public void testExecuterInstructions() {

        verifyException(tondeuseCasExemple, IllegalArgumentException.class).executerInstructions(null);
        // Premier cas de base.
        assertEquals(tondeuseCasExemple.toString(), "1 2 N");
        tondeuseCasExemple.executerInstructions(terrain);
        assertEquals(tondeuseCasExemple.toString(), "1 3 N");

        // Second cas de base.
        assertEquals(tondeuseCasExemple2.toString(), "3 3 E");
        tondeuseCasExemple2.executerInstructions(terrain);
        assertEquals(tondeuseCasExemple2.toString(), "5 1 E");

        // Cas de sortie de terrain.
        assertEquals(tondeuseCasSortieTerrain.toString(), "7 6 E");
        tondeuseCasSortieTerrain.executerInstructions(terrain);
        assertEquals(tondeuseCasSortieTerrain.toString(), "10 8 E");

        // Cas de collision entre tondeuses.
        assertEquals(tondeuseCasCollisionTondeuse.toString(), "10 10 S");
        tondeuseCasCollisionTondeuse.executerInstructions(terrain);
        assertEquals(tondeuseCasCollisionTondeuse.toString(), "7 8 S");
    }
}
