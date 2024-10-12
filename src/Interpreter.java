import java.io.IOException;
import java.util.Arrays;


public class Interpreter {
    public int CO;
    public int nbMouvement;
    public int nbCollision;
    public int nbInstructionInterprete;
    public int[] Mem;
    private Labyrinthe labyrinthe;

    public Interpreter(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.CO = 0;
        this.nbMouvement = 0;
        this.nbCollision = 0;
        this.nbInstructionInterprete = 0;
        this.Mem = new int[labyrinthe.nbColonne * labyrinthe.nbLigne];

    }

    public void ava(Tortue tortue, int imm){
        int stepsToDo = imm;
        for ( int i = 0; i < stepsToDo; i++ ){
            if ( labyrinthe.aMur(tortue.getPosition(),tortue.getDirection()) ){
                nbCollision++;
            }
            else{
                tortue.moveForward();
                nbMouvement++;
            }
        }
        CO++;
        nbMouvement++;
        nbCollision++;
        nbInstructionInterprete++;
        printPosition(tortue.getPosition());
        printDirection(tortue.getDirection());
    }
    private void met(int imm){

    }
    public void mou(Tortue tortue, int imm){
        int x = tortue.getPosition().x();
        int y = tortue.getPosition().y();
        int memPosition = y*x+x;

        Mem[memPosition] = (Mem[memPosition] | imm);
        CO++;
        printPosition(tortue.getPosition());
        printDirection(tortue.getDirection());
    }
    public void tad(Tortue tortue){
        CO++;
        nbMouvement++;
        nbInstructionInterprete++;
        tortue.direction = tortue.direction.tourneHoraire();
        printPosition(tortue.getPosition());
        printDirection(tortue.getDirection());
    }

    public void tag(Tortue tortue){
        CO++;
        nbMouvement++;
        nbInstructionInterprete++;
        tortue.direction = tortue.direction.tourneAntiHoraire();
        printPosition(tortue.getPosition());
        printDirection(tortue.getDirection());
    }

    private void s(int etiq){

    }
    public void sma(Tortue tortue, int etiq){
        if ( labyrinthe.aMur(tortue.getPosition(),tortue.getDirection()) ){
            nbInstructionInterprete++;
            CO = etiq;
            printPosition(tortue.getPosition());
            printDirection(tortue.getDirection());
        }
        else{
            nbInstructionInterprete++;
            CO++;
            printPosition(tortue.getPosition());
            printDirection(tortue.getDirection());
        }
    }
    public void sez(Tortue tortue, int imm, int etiq){
        int x = tortue.getPosition().x();
        int y = tortue.getPosition().y();
        int memPosition = y*x+x;
        if( (imm & Mem[memPosition]) == 0){
            CO = etiq;
            printPosition(tortue.getPosition());
            printDirection(tortue.getDirection());
        }
        else{
            CO++;
            printPosition(tortue.getPosition());
            printDirection(tortue.getDirection());
        }

    }
    public void sou(Tortue tortue, int imm, int etiq){
        int x = tortue.getPosition().x();
        int y = tortue.getPosition().y();
        int memPosition = y*x+x;

        if((imm | Mem[memPosition]) == 15){
            CO = etiq;
            printPosition(tortue.getPosition());
            printDirection(tortue.getDirection());
        }
        else{
            CO++;
            printPosition(tortue.getPosition());
            printDirection(tortue.getDirection());
        }
    }
    private void sdi(Direction dir, int etiq){

    }
    public void fin(Tortue tortue){
        nbInstructionInterprete++;
        printPosition(tortue.getPosition());
        printDirection(tortue.getDirection());
        System.out.print("\nNombre d’instructions interprétées : " + nbInstructionInterprete +"\n");
        System.out.print("Nombre de mouvements : " + nbMouvement + "\n");
        System.out.print("Nombre de collisions : " + nbCollision + "\n");
        System.exit(0);
    }

    public void runCommandLine(Tortue tortue, Command command)throws IOException, Exception{

        if(command.commandImm == 0 && command.commandEtiq == 0) {
            Class.forName("Interpreter").getMethod(command.command, Tortue.class).invoke(this, tortue);
        }
        else if(command.commandImm >= 1 && command.commandEtiq == 0) {
            Class.forName("Interpreter").getMethod(command.command, Tortue.class, int.class).
                    invoke(this, tortue, command.commandImm);
        }
        else if(command.commandImm == 0 && command.commandEtiq >= 1) {
            Class.forName("Interpreter").getMethod(command.command, Tortue.class, int.class).
                    invoke(this, tortue, command.commandEtiq);
        }
        else{
            Class.forName("Interpreter").getMethod(command.command, Tortue.class, int.class, int.class).
                    invoke(this, tortue, command.commandImm, command.commandEtiq);
        }
    }


    public void printPosition(Vecteur position) {
        System.out.print(position.toString() + " ");
    }
    public void printDirection(Direction direction) {
        System.out.print(direction.toString() + "\n");
    }

    public void interpretLine(Tortue tortue) throws Exception {
        System.out.print(CO + " : ");
        runCommandLine(tortue, tortue.processeur.memory.get(CO));
    }
}
