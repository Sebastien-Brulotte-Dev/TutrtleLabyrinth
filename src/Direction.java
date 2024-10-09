

public enum Direction {
    Nord( new Vecteur( 0, -1 ) ),
    Ouest( new Vecteur( -1, 0 ) ),
    Sud( new Vecteur( 0, 1 ) ),
    Est( new Vecteur( 1, 0 ) ),
    ;
    private Vecteur vecteurDeplacement;

    Direction( Vecteur vecteurDeplacement ) {
        this.vecteurDeplacement = vecteurDeplacement;
    }

    /**
     * Retourne la prochaine direction en sens anti-horaire.
     * @return la prochaine direction dans l'ordre : Nord, Ouest, Sud, Est, ...
     */
    public Direction tourneAntiHoraire() {
        int indice = ordinal();
        return values()[ ( indice == 3 ) ? 0 : indice + 1 ];
    }

    /**
     * Retourne la prochaine direction en sens horaire.
     * @return la prochaine direction dans l'ordre : Est, Sur, Ouest, Nord, ...
     */
    public Direction tourneHoraire() {
        int indice = ordinal();
        return values()[ ( indice == 0 ) ? 3 : indice - 1 ];
    }

    public Vecteur getVecteurDeplacement() {
        return vecteurDeplacement;
    }
}
