
/*
 Nom : Sebastien Brulotte
 Code Permanent :BRUS31037900
*/


import java.util.Scanner;

public class Principal {
    public static void main( String [] argv ) throws Exception {
        Scanner clavier = new Scanner( System.in );

        System.out.print( "Entrez le nom du fichier contenant la description du Labyrinthe : " );
        String nomFichierLabyrinthe = "lab2.txt";/*clavier.next();*/
        Scanner entreesLabyrinthe = Lecteurs.ouvrirScanner( nomFichierLabyrinthe );
        Labyrinthe labyrinthe = Labyrinthe.lire( entreesLabyrinthe );
        entreesLabyrinthe.close();

        System.out.println( labyrinthe );

        Scanner clavier2 = new Scanner( System.in );

        System.out.print( "Entrez le nom du fichier contenant le programme a executer : " );
        String nomFichierProgramme = "prog2b.txt" /*clavier2.next()*/;

        Scanner programEntry = Lecteurs.ouvrirScanner( nomFichierProgramme );

        Processeur processeur = Processeur.readProgramToMemory(programEntry, labyrinthe);

        programEntry.close();

        System.out.println( processeur );


//        clavier2.close();

        System.out.print( "Entrez la position X de depart de la tortue : " );
//        int positionX = clavier.nextInt();
        int positionX = 1;

        System.out.print( "Entrez la position Y de depart de la tortue : " );
//        int positionY = clavier.nextInt();
        int positionY = 2;
        clavier.close();

        Tortue tortue = new Tortue(new Vecteur(positionX, positionY), labyrinthe);
        tortue.processeur = processeur;
        for (int i = 0; i < processeur.memory.size(); i++){
            tortue.processeur.interpreter.interpretLine(tortue);
        }
    }
}
