import java.io.IOException;
import java.util.*;

public class Program {

    protected ArrayList<Command> commandList;

    public Program(ArrayList<Command> commandList){
        this.commandList = commandList;
    }

    public static Program read(Scanner commandsFile)throws Exception {

        ArrayList<Command> commandList = new ArrayList<>();

        int i = 0;

        while(commandsFile.hasNext()) {

            String nextCommandStatement = Lecteurs.lireCommande(commandsFile);
//            System.out.println(i + " : " + nextCommandStatement + "\n");
            Command nextCommand = new Command(i, nextCommandStatement);
            commandList.add(nextCommand);
            ++i;
        }

        return new Program(commandList);
    }
}
