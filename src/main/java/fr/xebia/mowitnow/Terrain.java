package fr.xebia.mowitnow;


import java.util.ArrayList;

/**
 * Défini un terrain par ses dimensions et les tondeuses qui se trouvent dessus.
 *
 * @author Minh-Trieu HA
 */
public class Terrain {

    private int longueur;

    private int largeur;

    private ArrayList<Tondeuse> listeTondeuses;

    public Terrain(int longueur, int largeur) throws IllegalArgumentException {

        if (0 >= longueur || 0 >= largeur) {
            throw new IllegalArgumentException("Les dimensions du terrain doivent être positives.");
        }

        this.longueur = longueur;
        this.largeur = largeur;
        this.listeTondeuses = new ArrayList<Tondeuse>();
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public ArrayList<Tondeuse> getListeTondeuses() {
        return this.listeTondeuses;
    }

    public void setListeTondeuses(ArrayList<Tondeuse> listeTondeuses) {
        this.listeTondeuses = listeTondeuses;
    }

    /**
     * Permet d'ajouter une tondeuse au terrain si son emplacement est valide.
     * @param tondeuse
     * @throws IllegalArgumentException
     */
    public void ajouterTondeuse (Tondeuse tondeuse) throws IllegalArgumentException, ConfigurationException {

        if(null == tondeuse) {
            throw new IllegalArgumentException("Tondeuse incorrecte.");
        }
        int tondeuseX = tondeuse.getPosition().getCoordonneeX();
        int tondeuseY = tondeuse.getPosition().getCoordonneeY();

        if(0 > tondeuseX || this.longueur < tondeuseX) {
            throw new IllegalArgumentException("La coordonnée X = " + tondeuseX + " est en dehors des proportion du terrain.");
        }

        if(0 > tondeuseY || this.largeur < tondeuseY) {
            throw new IllegalArgumentException("La coordonnée Y = " + tondeuseY + " est en dehors des proportion du terrain.");
        }

        if (emplacementEstValide(tondeuseX, tondeuseY)) {
            this.listeTondeuses.add(tondeuse);
        } else {
            throw new ConfigurationException("Emplacement déjà occupé par une tondeuse.");
        }

    }

    /**
     * Vérifie si l'emplacement de coordonnée (x,y) est dans le terrain et libre.
     * @param x
     * @param y
     * @return true si l'emplacement est valide, false dans le cas contraire
     */
    public boolean emplacementEstValide(int x, int y) {

        if (0 > x || 0 > y) {
            return false;
        }

        if (x > this.longueur || y > this.largeur) {
            return false;
        }

        for (Tondeuse tondeuse : this.listeTondeuses) {
            if (x == tondeuse.getPosition().getCoordonneeX() && y == tondeuse.getPosition().getCoordonneeY()) {
                return false;
            }

        }
        return true;
    }

}
