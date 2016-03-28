package fr.xebia.mowitnow;

/**
 * Défini une orientation selon les quatres points cardinaux anglais et les opérations d'orientation dessus.
 *
 * @author Minh-Trieu HA
 */
public enum Orientation {

    N {
        public Orientation recupererOrientationAGauche() {
            return W;
        }

        public Orientation recupererOrientationADroite() {
            return E;
        }
    }, E {
        public Orientation recupererOrientationAGauche() {
            return N;
        }

        public Orientation recupererOrientationADroite() {
            return S;
        }
    }, S {
        public Orientation recupererOrientationAGauche() {
            return E;
        }

        public Orientation recupererOrientationADroite() {
            return W;
        }
    }, W {
        public Orientation recupererOrientationAGauche() {
            return S;
        }

        public Orientation recupererOrientationADroite() {
            return N;
        }
    };

    public abstract Orientation recupererOrientationAGauche();

    public abstract Orientation recupererOrientationADroite();


}