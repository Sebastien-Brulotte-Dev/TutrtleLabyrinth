
/*
 Nom : Sebastien Brulotte
 Code Permanent :BRUS31037900
*/


import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main( String [] argv ) throws Exception {
        Scanner clavier = new Scanner( System.in );

        System.out.print( "Entrez le nom du fichier contenant la description du Labyrinthe : " );
        String nomFichierLabyrinthe = "lab1.txt";/*clavier.next();*/
        Scanner entreesLabyrinthe = Lecteurs.ouvrirScanner( nomFichierLabyrinthe );
        Labyrinthe labyrinthe = Labyrinthe.lire( entreesLabyrinthe );
        entreesLabyrinthe.close();

        System.out.println( labyrinthe );

//        clavier.close();



        Scanner clavier2 = new Scanner( System.in );

        System.out.print( "Entrez le nom du fichier contenant le programme a executer : " );
        String nomFichierProgramme = "prog1.txt" /*clavier2.next()*/;

        Scanner programEntry = Lecteurs.ouvrirScanner( nomFichierProgramme );

        Program program = Program.read(programEntry);

        programEntry.close();

        System.out.println( program );


//        clavier2.close();




        Tortue tortue = new Tortue();

        System.out.print( "Entrez la position X de depart de la tortue : " );
//        int positionX = clavier.nextInt();
        int positionX = 0;

        System.out.print( "Entrez la position Y de depart de la tortue : " );
//        int positionY = clavier.nextInt();
        int positionY = 0;

        tortue.setPosition(positionX, positionY);
        System.out.println( tortue );

        clavier.close();
    }
}
