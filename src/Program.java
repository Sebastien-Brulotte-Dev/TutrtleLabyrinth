import java.util.*;

public class Program {

    protected ArrayList<Command> commandList;

    public Program(ArrayList<Command> commandList){

        this.commandList = commandList;
    }

    private static String retrieveCommandName(String commandToStrip){
        String strippedCommand;
        if(commandToStrip.contains(" ")){
            String[] commandStrings = commandToStrip.split(" ");
            strippedCommand = commandStrings[0];
        }
        else{
            strippedCommand = commandToStrip;
        }
        return strippedCommand;
    }

    private static boolean validateCommand(String commandToValidate){

        boolean estValide = false;

        if((commandCharCounter(retrieveCommandName(commandToValidate)) == 3 ||
            commandCharCounter(retrieveCommandName(commandToValidate)) == 1)){
            estValide = true;
        }
        return estValide;
    }

    public static int commandCharCounter(String input) {
        int k = 0;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) != (char)32 && input.charAt(i) != (char)13) {
                k++;
            }
        }
        return k;
    }

    public static Program read(Scanner commandsFile)throws Exception {

        ArrayList<Command> commandList = new ArrayList<>();
        int i = 0;

        while(commandsFile.hasNext()) {

            String nextCommandStatement = Lecteurs.lireCommande(commandsFile);

            if(!(validateCommand(nextCommandStatement))) {
                System.out.println("La commande " + retrieveCommandName(nextCommandStatement) + "n'est pas" +
                                   " une commande valide, veuillez verifier le programme\n");
            }

            if(nextCommandStatement.length() >= 5) {
                String nextCommandModifyer = nextCommandStatement.substring(4, 5);
                int n = Integer.parseInt(nextCommandModifyer);
                Command nextCommand = new Command(i, nextCommandStatement, n);
                commandList.add(nextCommand);
            }
            else{
                Command nextCommand = new Command(i, nextCommandStatement);
                commandList.add(nextCommand);
            }
            ++i;
        }

        return new Program(commandList);
    }
}
