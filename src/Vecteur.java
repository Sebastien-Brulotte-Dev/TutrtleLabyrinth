/**
 * Cette classe (structure) décrit une position dans un grille à 2 dimensions.
 * La position est décrite par deux coordonnées : x (no de colonne) et (no de ligne).
 * Ces vecteur contiennent des valeurs entières comme coordonnés.
 */
public class Vecteur {
    private int x;
    private int y;

    /**
     * Construit un vecteur.
     * @param x le numéro de colonne.
     *          pré-condition : 0 <= x
     * @param y le numéro de ligne.
     *          pré-condition : 0 <= y
     */
    public Vecteur( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retourne la coordonnée 'x' du vecteur.
     * @return la coordonnée 'x' du vecteur.
     */
    public int x() {
        return x;
    }

    /**
     * Retourne la coordonnée 'y' du vecteur.
     * @return la coordonnée 'y' du vecteur.
     */
    public int y() {
        return y;
    }

    /**
     * retourne un vecteur qui est le résultat de l'addition (vectorielle) de deux vecteurs.
     * @param operandeDroite Le vecteur qui est additionnée à 'this'.
     * @return Le nouveau vecteyr.
     */
    public Vecteur add( Vecteur operandeDroite ) {
        return new Vecteur( x + operandeDroite.x, y + operandeDroite.y );
    }

    /**
     * Construit une chaîne de caractères représentant le contenu du vecteur.
     * @return Une chaîne de caractères contenant les valeurs de 'x' et 'y' entre
     * parenthèse et séparées par une virgule.
     */
    @Override
    public String toString() {
        return "( " + x + ", " + y + " )";
    }
}
