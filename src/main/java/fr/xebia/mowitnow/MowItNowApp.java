package fr.xebia.mowitnow;


import java.io.*;
import java.util.ArrayList;

/**
 * Classe principale du projet MowItNow.
 *
 * @author Minh-Trieu HA
 */
public class MowItNowApp {

    public static void main(String [] args) {
        if (null == args || 0 == args.length) {
            new IllegalArgumentException("La configuration est attendu en argument du programme.").printStackTrace();
        } else {
            Terrain terrain = null;
            try {
                ArrayList<String> listeLigneFichier = Controlleur.convertirParametreProgrammeEnList(args[0]);
                terrain = Controlleur.initialisationTerrain(listeLigneFichier);
                Controlleur.miseEnMarcheTondeuse(terrain);
            } catch (ConfigurationException | IllegalArgumentException | IOException  e) {
                e.printStackTrace();
            }
            if (null != terrain) {
                for (Tondeuse tondeuse : terrain.getListeTondeuses()) {
                    System.out.println(tondeuse);
                }
            }
        }
    }
}

