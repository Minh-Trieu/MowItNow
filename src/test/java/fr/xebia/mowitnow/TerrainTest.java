package fr.xebia.mowitnow;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.googlecode.catchexception.CatchException.*;

/**
 * Classe test de la classe Terrain.
 *
 * @author Minh-Trieu HA
 */
public class TerrainTest {

    /**
     * Test du constructeur avec X négatif.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTerrainNegatifX() {
        Terrain terrain = new Terrain(-1, 5);
    }

    /**
     * Test du constructeur avec Y négatif.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTerrainNegatifY() {
        Terrain terrain = new Terrain(4, -5);
    }

    /**
     * Test du constructeur avec X et Y négatif.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTerrainNegatifXY() {
        Terrain terrain = new Terrain(-3, -5);
    }

    /**
     * Test du constructeur avec X nul.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTerrainNulX() {
        Terrain terrain = new Terrain(0, 5);
    }

    /**
     * Test du constructeur avec Y nul.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTerrainNulY() {
        Terrain terrain = new Terrain(3, 0);
    }

    /**
     * Test du constructeur avec Y nul.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTerrainNulXY() {
        Terrain terrain = new Terrain(0, 0);
    }

    /**
     * Test du constructeur avec dimensions valides.
     */
    @Test
    public void testTerrain() {
        Terrain terrain = new Terrain(5, 18);
    }


    /**
     * Test du de la méthode d'ajout de tondeuse au terrain.
     */
    @Test
    public void ajouterTondeuse() {
        Terrain terrain = new Terrain(4, 7);

        try {
            verifyException(terrain, IllegalArgumentException.class).ajouterTondeuse(null);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }


        Position position = new Position(1, 2);
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
        Tondeuse tondeuse = new Tondeuse(position, orientation, instructions);

        try {
            terrain.ajouterTondeuse(tondeuse);
            verifyException(terrain, ConfigurationException.class).ajouterTondeuse(tondeuse);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }


    }
}
