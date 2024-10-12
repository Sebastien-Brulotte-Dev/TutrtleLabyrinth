public class Command {
    int commandNumber;
    String command;
    public int commandImm;
    public int commandEtiq;

    public Command(int commandNumber, String command) {
        String[] commandAndModifier = command.split(" ");
        this.commandNumber = commandNumber;
        this.command = commandAndModifier[0].trim();
        if(commandAndModifier.length > 1) {
            this.commandImm = Integer.parseInt(commandAndModifier[1].trim());
        }
        if(commandAndModifier.length > 2) {
            this.commandEtiq = Integer.parseInt(commandAndModifier[2].trim());
        }
    }

    public String toString() {
//
        return commandNumber + " " + command.trim() + " " + commandImm + " " + commandEtiq;
    }

}
