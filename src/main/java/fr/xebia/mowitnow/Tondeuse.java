package fr.xebia.mowitnow;


import java.util.ArrayList;

/**
 * Défini une tondeuse par sa position sur le terrain, une orientation et une liste d'instruction programmée.
 *
 * @author Minh-Trieu HA
 */
public class Tondeuse {
    private Position position;
    private Orientation orientation;
    private ArrayList<Instruction> instructions;

    public Tondeuse(Position position, Orientation orientation, ArrayList<Instruction> instructions) throws IllegalArgumentException {
        if (null == position) {
            throw new IllegalArgumentException("Position de tondeuse incorrecte.");
        }

        if (null == orientation) {
            throw new IllegalArgumentException("orientation de tondeuse incorrecte.");
        }

        if (null == instructions) {
            this.instructions = new ArrayList<Instruction>();
        } else {
            this.instructions = instructions;
        }
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Permet d'exécuter la série d'instruction affecté à une tondeuse.
     *
     * @param terrain
     * @throws IllegalArgumentException
     */
    public void executerInstructions(Terrain terrain) throws IllegalArgumentException {
        if (null == terrain) {
            throw new IllegalArgumentException("Terrain invalide.");
        }

        for (Instruction instruction : instructions) {
            this.executerInstruction(instruction, terrain);
        }


    }

    /**
     * Permet d'exécuter une instruction unique et de modifier la position de la tondeuse si elle est valide.
     *
     * @param instruction
     * @param terrain
     * @throws IllegalArgumentException
     */
    private void executerInstruction(Instruction instruction, Terrain terrain) throws IllegalArgumentException {
        if (null == instruction) {
            throw new IllegalArgumentException("Instruction invalide.");
        }
        switch (instruction) {
            case A:
                Position prochainePosition = recupererProchainEmplacement();
                if (terrain.emplacementEstValide(prochainePosition.getCoordonneeX(), prochainePosition.getCoordonneeY())) {
                    this.position = prochainePosition;
                }
                break;

            case G:
                this.orientation = this.orientation.recupererOrientationAGauche();
                break;

            case D:
                this.orientation = this.orientation.recupererOrientationADroite();
                break;

            default:
                break;
        }


    }

    /**
     * Permet de récupérer la position qu'induirait un déplacement.
     *
     * @return
     */
    private Position recupererProchainEmplacement() throws IllegalArgumentException {
        Position prochainePosition = null;
        switch (this.orientation) {

            case N:
                prochainePosition = new Position(0, 1);
                break;

            case E:
                prochainePosition = new Position(1, 0);
                break;

            case W:
                prochainePosition = new Position(-1, 0);
                break;

            case S:
                prochainePosition = new Position(0, -1);
                break;

            default:
                break;
        }
        prochainePosition.ajouterPosition(this.position);
        return prochainePosition;
    }

    @Override
    public String toString() {
        return this.position.getCoordonneeX() + " " + this.position.getCoordonneeY() + " " + this.orientation;
    }
}
