package fr.xebia.mowitnow;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Classe Orchestratrice du projet MowItNow.
 *
 * @author Minh-Trieu HA
 */
public class Controlleur {

    /**
     * Convertie le paramètre d'entrée du programme en une liste de string
     * @param parametreProgramme
     * @return
     */
    public static ArrayList<String> convertirParametreProgrammeEnList(String parametreProgramme) throws IOException, IllegalArgumentException {
        if(null == parametreProgramme || parametreProgramme.isEmpty()) {
            throw new IllegalArgumentException("Paramètre programme invalide.");
        }

        ArrayList<String> listeLigneFichier = null;

        File fichierConfiguration = new File(parametreProgramme);
        if (fichierConfiguration.exists() && !fichierConfiguration.isDirectory()) {
            try (InputStream fluxEntree = new FileInputStream(fichierConfiguration);
                 InputStreamReader lecteurFluxEntree = new InputStreamReader(fluxEntree);
                 BufferedReader bufferLecture = new BufferedReader(lecteurFluxEntree);) {
                listeLigneFichier = new ArrayList<>(bufferLecture.lines().collect(Collectors.toList()));
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e) {
                throw e;
            }
        } else {
            listeLigneFichier = new ArrayList<String>(Arrays.asList(parametreProgramme.split("\\n")));
        }

        return listeLigneFichier;
    }

    /**
     * Initialise le terrain et ses tondeuses aux positions leur initiale.
     *
     * @param listeLigneFichier
     * @return
     */
    public static Terrain initialisationTerrain(ArrayList<String> listeLigneFichier) throws IllegalArgumentException, ConfigurationException {
        if (null == listeLigneFichier) {
            throw new IllegalArgumentException("Configuration eronnée.");
        }
        if (listeLigneFichier.isEmpty()) {
            throw new ConfigurationException("Le fichier est vide.");
        }

        Iterator<String> iterateurListeLigneFichier = listeLigneFichier.iterator();
        Terrain terrain = null;
        try {
            String[] configurationTerrain = iterateurListeLigneFichier.next().split(" ");
            if (2 != configurationTerrain.length) {
                throw new ConfigurationException("La dimension du terrain est mal saisi.");
            }
            int longueurTerrain = Integer.parseInt(configurationTerrain[0]);
            int largeurTerrain = Integer.parseInt(configurationTerrain[1]);

            terrain = new Terrain(longueurTerrain, largeurTerrain);

            while (iterateurListeLigneFichier.hasNext()) {


                String[] positionInitialTondeuse = iterateurListeLigneFichier.next().split(" ");
                if (3 != positionInitialTondeuse.length) {
                    throw new ConfigurationException("Position initiale d'une tondeuse invalide.");
                }

                int coordonneeTondeuseX = Integer.parseInt(positionInitialTondeuse[0]);
                int coordonneeTondeuseY = Integer.parseInt(positionInitialTondeuse[1]);
                Orientation orientationTondeuse = Orientation.valueOf(positionInitialTondeuse[2]);
                Position positionTondeuse = new Position(coordonneeTondeuseX, coordonneeTondeuseY);
                String ligneInstructions = null;

                if (iterateurListeLigneFichier.hasNext()) {
                    ligneInstructions = iterateurListeLigneFichier.next();
                } else {
                    throw new ConfigurationException("Série d'instruction manquante.");
                }

                ArrayList<Instruction> instructions = new ArrayList<Instruction>();
                try {
                    for (int i = 0; i < ligneInstructions.length(); i++) {
                        instructions.add(Instruction.valueOf(String.valueOf(ligneInstructions.charAt(i))));
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                Tondeuse tondeuse = new Tondeuse(positionTondeuse, orientationTondeuse, instructions);
                terrain.ajouterTondeuse(tondeuse);
            }
        } catch (NumberFormatException e) {
            throw new ConfigurationException(e);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return terrain;
    }

    /**
     * Met en marche les tondeuses pour exécuter leur serie d'instructions.
     *
     * @param terrain
     * @throws IllegalArgumentException
     */
    public static void miseEnMarcheTondeuse(Terrain terrain) throws IllegalArgumentException {

        if (null == terrain) {
            throw new IllegalArgumentException("Terrain invalide.");
        }

        for (Tondeuse tondeuse : terrain.getListeTondeuses()) {
            tondeuse.executerInstructions(terrain);
        }
    }
}
