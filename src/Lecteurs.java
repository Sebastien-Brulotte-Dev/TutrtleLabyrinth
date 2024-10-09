
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lecteurs {
    public static Scanner ouvrirScanner( String nomFichier ) {
        assert null != nomFichier;

        Scanner entrees = null;

        try {
            File fichierEntrees = new File( nomFichier );
            entrees = new Scanner( fichierEntrees );
        } catch( FileNotFoundException e ) {
            System.err.println( "Labyrinthe::Labyrinthe : Impossible d'ouvrir le fichier \"" + nomFichier + "\".");
            System.exit( -1 );
        }

        return entrees;
    }

    public static int lireEntier( Scanner entrees ) {
        int resultat = 0;

        try {
            resultat = entrees.nextInt();
        } catch( InputMismatchException e ) {
            System.err.println( "Lecteurs::lireEntier : Ne peu lire un entier car le texte ne represente pas un entier.");
            System.exit( -1 );
        } catch( NoSuchElementException e ) {
            System.err.println( "Lecteurs::lireEntier : Ne peu lire un entier car il n'y a plus d'entrees.");
            System.exit( -1 );
        } catch( IllegalStateException e ) {
            System.err.println( "Lecteurs::lireEntier : Ne peu lire un entier car le lecteur est ferme.");
            System.exit( -1 );
        }

        return resultat;

    }
    public static String lireCommande( Scanner entrees ) throws Exception {
        String prochaineCommande = null;

        try {
              prochaineCommande = entrees.useDelimiter("\\n").next();

        } catch( NoSuchElementException e ) {
            System.err.println( "Lecteurs::lireCommandes : Ne peu lire de commande car il n'y a plus d'entrees.");
            System.exit( -1 );
        } catch( IllegalStateException e ) {
            System.err.println( "Lecteurs::lireCommandes : Ne peu lire de commande car le lecteur est ferme.");
            System.exit( -1 );
        }catch( Exception e ) {
            System.err.println( "Lecteurs::lireEntier : Ne peu lire un entier car le texte ne represente pas un entier.");
            System.exit( -1 );
        }

        return prochaineCommande;

    }
}
