import java.util.ArrayList;
import java.util.Scanner;

public class Processeur {

    ArrayList<Command> memory;
    public Interpreter interpreter;

    public Processeur(ArrayList<Command> program, Labyrinthe labyrinthe) {
        this.memory = program;
        interpreter = new Interpreter(labyrinthe);
    }
    private static String[] splitCommandNameAndModifyer(String commandToStrip){
        return commandToStrip.split(" ");
    }

    private static boolean validateCommandName(String commandName){
        boolean estValide = true;

        for(char c : commandName.toCharArray()){
            if (!Utility.isLowerCaseLetter(c)) {
                estValide = false;
            }
        }
        return estValide;
    }

    private static boolean validateCommandLength(String commandName){

        boolean estValide = true;
        int commandStatementLength = (splitCommandNameAndModifyer(commandName)[0]).trim().length();

        if(!(commandStatementLength == 1) && !(commandStatementLength == 3)){
            estValide = false;
        }
        return estValide;
    }

    private static boolean validateCommand(String commandToValidate){


        return validateCommandName(splitCommandNameAndModifyer(commandToValidate)[0].trim()) &&
                validateCommandLength(splitCommandNameAndModifyer(commandToValidate)[0].trim());
    }

    private static boolean validateCommandLine(String lineToValidate){
        if(!(validateCommand(lineToValidate))) {
            System.out.println("La commande " + splitCommandNameAndModifyer(lineToValidate)[0] + " n'est pas" +
                    " une commande valide, veuillez verifier le programme\n");
            System.exit(0);
        }
        return validateCommand(lineToValidate);
    }

    public static Processeur readProgramToMemory(Scanner commandsFile, Labyrinthe labyrinthe)throws Exception {

        ArrayList<Command> memory = new ArrayList<>();
        int i = 0;

        while(commandsFile.hasNext()) {

            String nextCommandStatement = Lecteurs.lireCommande(commandsFile);
            validateCommandLine(nextCommandStatement);

            Command nextCommand = new Command(i, nextCommandStatement);
            memory.add(nextCommand);
            ++i;
        }

        return new Processeur(memory, labyrinthe);
    }
}
