
import java.util.Scanner;

public class Labyrinthe {
    private enum Case {
        VIDE( false, false, false, "    ", "    " ),
        N( false, false, true, "+---", "    " ),
        O( false, true, false, "+   ", "|   " ),
        NO( false, true, true, "+---", "|   " ),
        X( true, false, false, "    ", "  o " ),
        XN( true, false, true, "+---", "  o " ),
        XO( true, true, false, "+   ", "| o "  ),
        XNO( true, true, true, "+---", "| o "  ),
        ;
        public boolean estSortie;

        public boolean aMurOuest;
        public boolean aMurNord;

        private String ligne1;
        private String ligne2;

        Case( boolean estSortie, boolean aMurOuest, boolean aMurNord, String ligne1, String ligne2 ) {
            this.estSortie = estSortie;
            this.aMurOuest = aMurOuest;
            this.aMurNord = aMurNord;
            this.ligne1 = ligne1;
            this.ligne2 = ligne2;
        }

        static public Case lire( Scanner entrees ) {
            Case resultat = null;

            try {
                resultat = values()[ Lecteurs.lireEntier( entrees ) ];
            } catch( IndexOutOfBoundsException e ) {
                System.err.println( "Case::lireCase : L'entier n'est pas valide, doit etre entre 0 et 7.");
                System.exit( -1 );
            }

            return resultat;
        }

        public String toStringL1() {
            return ligne1;
        }

        public String toStringL2() {
            return ligne2;
        }
    }
    protected int nbColonne;
    protected int nbLigne;
    protected Case [][] cases;

    /**
     * Lit un fichier contenant la description d'un labyrinthe et construit une instance du
     * labyrinthe.
     * @param entrees Un scanner qui a ete initialise au debut du fichier contenant la
     *                description du labyrinthe.
     * @return une instance du labyrinthe.
     */
    public static Labyrinthe lire( Scanner entrees ) {
        int nbColonne = Lecteurs.lireEntier( entrees );
        if( nbColonne <= 0 ) {
            System.err.println( "Labyrinthe::Labyrinthe : Le nombre de colonne doit etre une valeur plus grande que 0.");
            System.exit( -1 );
        }

        int nbLigne = Lecteurs.lireEntier( entrees );
        if( nbLigne <= 0 ) {
            System.err.println( "Labyrinthe::Labyrinthe : Le nombre de ligne doit etre une valeur plus grande que 0.");
            System.exit( -1 );
        }

        Labyrinthe resultat = new Labyrinthe( nbColonne, nbLigne );

        for( int y = 0; y < nbLigne; ++ y ) {
            for( int x = 0; x < nbColonne; ++ x ) {
                resultat.cases[y][x] = Case.lire( entrees );
            }
        }

        return resultat;
    }

    public Labyrinthe( int nbColonne, int nbLigne ) {
        this.nbColonne = nbColonne;
        this.nbLigne = nbLigne;

        cases = new Case[nbLigne][nbColonne];
    }

    /**
     * Verifie s'il y a un mur en regardant dans la direction indique a partir de la position
     * indique.
     * @param position La position de la case ou nous voulons verifier la presence d'un mur.
     * @param direction La direction ou nous regardons pour verifier la presence d'un mur.
     * @return
     */
    public boolean aMur( Vecteur position, Direction direction ) {
        return switch( direction ) {
            case Nord -> aMurNord( position );
            case Ouest -> aMurOuest( position );
            case Sud -> aMurSud( position );
            case Est -> aMurEst( position );
        };
    }

    private boolean aMurNord( Vecteur position ) {
        return cases[ position.y() ][ position.x() ].aMurNord;
    }

    private boolean aMurSud( Vecteur position ) {
        return ( position.y() == nbLigne - 1 ) || ( cases[ position.y() + 1 ][ position.x() ].aMurNord );
    }

    private boolean aMurOuest( Vecteur position ) {
        return cases[ position.y() ][ position.x() ].aMurOuest;
    }

    private boolean aMurEst( Vecteur position ) {
        return ( position.x() == nbColonne - 1 ) || ( cases[ position.y() ][ position.x() + 1 ].aMurOuest );
    }

    /**
     * Verifie si la case du labyrinthe contient une sortie.
     * @param position la position de la case a verifier.
     * @return true si la case est une sortie, false sinon.
     */
    public boolean estSortie( Vecteur position ) {
        return cases[ position.y() ][ position.x() ].estSortie;
    }

    @Override
    public String toString() {
        String resultat = "";

        for( int y = 0; y < nbLigne; ++ y ) {
            String temp = "";
            for( int x = 0; x < nbColonne; ++ x ) {
                resultat += cases[ y ][ x ].toStringL1();
                temp += cases[ y ][ x ].toStringL2();
            }
            resultat += "+\n" + temp + "|\n";
        }
        for( int x = 0; x < nbColonne; ++ x ) {
            resultat += "+---";
        }
        resultat += "+";

        return resultat;
    }
}
