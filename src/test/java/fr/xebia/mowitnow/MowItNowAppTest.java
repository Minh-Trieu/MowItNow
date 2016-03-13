package fr.xebia.mowitnow;

import org.junit.Test;

/**
 * Classe test de la classe MowItNowApp.
 *
 * @author Minh-Trieu HA
 */
public class MowItNowAppTest {

    /**
     * Classe de test de l'orchestrateur du programme.
     */
    @Test
    public void testMain() {
        String[] args = {""};
        String[] argsVide = {};
        String[] argsCorrect = {"5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA"};
        String[] argsIncorrecteDimensionTerrain = {"Z 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA"};
        String[] argsIncorrecteInstruction = {"Z 5\n1 2 N\nGAZAGAGAA\n3 3 E\nAADAADADDA"};
       try {
           MowItNowApp.main(null);
           MowItNowApp.main(args);
           MowItNowApp.main(argsVide);
           MowItNowApp.main(argsCorrect);
           MowItNowApp.main(argsIncorrecteDimensionTerrain);
           MowItNowApp.main(argsIncorrecteInstruction);
       } catch (IllegalArgumentException e) {
           e.printStackTrace();
       }

    }

}
