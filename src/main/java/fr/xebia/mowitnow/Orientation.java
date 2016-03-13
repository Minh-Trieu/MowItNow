package fr.xebia.mowitnow;

/**
 * Défini une orientation selon les quatres points cardinaux anglais et les opérations d'orientation dessus.
 *
 * @author Minh-Trieu HA
 */
public enum Orientation {

    N, E, W, S;

    /**
     * Retourne l'orientation à -90° de l'orientation actuelle.
     * @return Orientation
     */
    public Orientation recupererOrientationAGauche() {
        switch (this) {

            case N:
                return Orientation.W;

            case E:
                return Orientation.N;

            case W:
                return Orientation.S;

            case S:
                return Orientation.E;

            default:
                return null;
        }
    }

    /**
     * Retourne l'orientation à 90° de l'orientation actuelle.
     * @return Orientation
     */
    public Orientation recupererOrientationADroite() {
        switch (this) {

            case N:
                return Orientation.E;

            case E:
                return Orientation.S;

            case W:
                return Orientation.N;

            case S:
                return Orientation.W;

            default:
                return null;
        }
    }
}