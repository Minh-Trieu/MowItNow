package fr.xebia.mowitnow;

/**
 * Défini une position par des coordonnées X Y.
 *
 * @author Minh-Trieu HA
 */
public class Position {
    private int coordonneeX;
    private int coordonneeY;

    public Position(int coordonneeX, int coordonneeY) {
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
    }

    public int getCoordonneeY() {

        return coordonneeY;
    }

    public void setCoordonneeY(int coordonneeY) {

        this.coordonneeY = coordonneeY;
    }

    public int getCoordonneeX() {

        return coordonneeX;
    }

    public void setCoordonneeX(int coordonneeX) {
        this.coordonneeX = coordonneeX;
    }


    /**
     * Permet d'ajouter une position à la position actuelle.
     *
     * @param positionAjouter
     */
    public void ajouterPosition(Position positionAjouter) throws IllegalArgumentException{
        if (null == positionAjouter) {
            throw new IllegalArgumentException("La position à ajouter ne peut être null.");
        }
        this.coordonneeX = this.coordonneeX + positionAjouter.getCoordonneeX();
        this.coordonneeY = this.coordonneeY + positionAjouter.getCoordonneeY();
    }

}
