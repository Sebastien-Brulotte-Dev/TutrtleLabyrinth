
/*
 Nom : Sebastien Brulotte
 Code Permanent :BRUS31037900
*/


import java.util.Scanner;

public class Principal {
    public static void main( String [] argv ) {
        Scanner clavier = new Scanner( System.in );

        System.out.print( "Entrez le nom du fichier contenant la description du Labyrinthe : " );
        String nomFichierLabyrinthe = clavier.next();
        Scanner entreesLabyrinthe = Lecteurs.ouvrirScanner( nomFichierLabyrinthe );
        Labyrinthe labyrinthe = Labyrinthe.lire( entreesLabyrinthe );
        entreesLabyrinthe.close();

        System.out.println( labyrinthe );

        clavier.close();

        System.out.print( "Entrez le nom du fichier contenant le programme a executer : " );
        String nomFichierProgramme = clavier.next();
        Scanner programEntry = Lecteurs.ouvrirScanner( nomFichierProgramme );
        Program program = Program.read( programEntry );
        programEntry.close();

        System.out.println( program );

        clavier.close();

        Tortue tortue = new Tortue();

        System.out.print( "Entrez la position X de depart de la tortue : " );
        int positionX = clavier.nextInt();

        System.out.print( "Entrez la position Y de depart de la tortue : " );
        int positionY = clavier.nextInt();

        tortue.setPosition(positionX, positionY);

    }
}
