public class Interpreter {
    public int CO;
    public int nbMouvement;
    public int nbCollision;
    public int nbInstructionInterprete;
    public int[] Mem;

    public Interpreter() {
        this.CO = 0;


    }

    public void interpretLine(Tortue t){
        System.out.print(CO + " : ");
        //instruction code here
        System.out.print(t.getPosition().toString() + " ");
        System.out.println(t.getDirection().toString());
    }
}
