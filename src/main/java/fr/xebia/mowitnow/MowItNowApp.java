package fr.xebia.mowitnow;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Classe Orchestratrice du projet MowItNow.
 *
 * @author Minh-Trieu HA
 */
public class MowItNowApp {

    public static void main(String[] args) {
        if (null == args || 0 == args.length) {
            new IllegalArgumentException("La configuration est attendu en argument du programme.").printStackTrace();
        } else {
            ArrayList<String> listeLigneFichier = null;

                File fichierConfiguration = new File(args[0]);
                if(fichierConfiguration.exists() && !fichierConfiguration.isDirectory()) {
                    try {
                    InputStream fluxEntree = new FileInputStream(fichierConfiguration);
                    InputStreamReader lecteurFluxEntree = new InputStreamReader(fluxEntree);
                    BufferedReader bufferLecture = new BufferedReader(lecteurFluxEntree);
                    String ligneFichier;
                    listeLigneFichier = new ArrayList<String>();
                    while (null != (ligneFichier = bufferLecture.readLine())) {
                        listeLigneFichier.add(ligneFichier);
                    }

                    bufferLecture.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    listeLigneFichier = new ArrayList<String>(Arrays.asList(args[0].split("\\n")));
                }

            Terrain terrain = null;
            try {
                terrain = initialisationTerrain(listeLigneFichier);
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }

            try {
                miseEnMarcheTondeuse(terrain);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            if(null != terrain) {
                for (Tondeuse tondeuse : terrain.getListeTondeuses()) {
                    System.out.println(tondeuse);
                }
            }
        }
    }

    /**
     * Initialise le terrain et ses tondeuses aux positions leur initiale.
     * @param listeLigneFichier
     * @return
     */
    private static Terrain initialisationTerrain(ArrayList<String> listeLigneFichier) throws IllegalArgumentException, ConfigurationException {


        Iterator<String> iterateurListeLigneFichier = listeLigneFichier.iterator();
        Terrain terrain = null;
        try {
            if (null == listeLigneFichier) {
                throw new IllegalArgumentException("Configuration eronnée.");
            }
            if (listeLigneFichier.isEmpty()) {
                throw new ConfigurationException("Le fichier est vide.");
            }

            String[] configurationTerrain = iterateurListeLigneFichier.next().split(" ");
            if (2 != configurationTerrain.length) {
                throw new ConfigurationException("La dimension du terrain est mal saisi.");
            }
            int longueurTerrain = Integer.parseInt(configurationTerrain[0]);
            int largeurTerrain = Integer.parseInt(configurationTerrain[1]);

            terrain = new Terrain(longueurTerrain, largeurTerrain);

            String lignePositionInitialTondeuse;
            String instructionTondeuse;
            while (iterateurListeLigneFichier.hasNext()) {


                String[] positionInitialTondeuse = iterateurListeLigneFichier.next().split(" ");
                if (3 != positionInitialTondeuse.length) {
                    throw new ConfigurationException("Position initiale d'une tondeuse invalide.");
                }

                int coordonneeTondeuseX = Integer.parseInt(positionInitialTondeuse[0]);
                int coordonneeTondeuseY = Integer.parseInt(positionInitialTondeuse[1]);
                Orientation orientationTondeuse = Orientation.valueOf(positionInitialTondeuse[2]);
                Position positionTondeuse = new Position(coordonneeTondeuseX, coordonneeTondeuseY);
                String LigneInstructions = null;

                if( iterateurListeLigneFichier.hasNext()) {
                    LigneInstructions = iterateurListeLigneFichier.next();
                } else {
                    throw new ConfigurationException("Série d'instruction manquante.");
                }

                ArrayList<Instruction> instructions = new ArrayList<Instruction>();
                try {
                    for (int i = 0; i < LigneInstructions.length(); i++) {

                        instructions.add(Instruction.valueOf(String.valueOf(LigneInstructions.charAt(i))));
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
     * @param terrain
     * @throws IllegalArgumentException
     */
    private static void miseEnMarcheTondeuse(Terrain terrain) throws IllegalArgumentException{

        if(null == terrain) {
            throw new IllegalArgumentException("Terrain invalide.");
        }

        for (Tondeuse tondeuse : terrain.getListeTondeuses()) {
            tondeuse.executerInstructions(terrain);
        }
    }
}

