public class Command {
    String command;
    int commandNumber;
    public int commandModifier;

    public Command(int commandNumber, String command, int commandModifier) {
        this.command = command;
        this.commandModifier = commandModifier;
        this.commandNumber = commandNumber;
    }
    public Command(int commandNumber, String command) {
        this.command = command;
        this.commandNumber = commandNumber;
    }

}
