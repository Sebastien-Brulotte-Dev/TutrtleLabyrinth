
public class Tortue{

    public Processeur processeur;
    public Vecteur position;
    public Direction direction;

    public Tortue(Vecteur position, Labyrinthe labyrinthe) {
        this.position = position;
        this.direction = Direction.Nord;
    }
    public Tortue() {}

    public Vecteur getPosition() {
        return position;
    }
    public Direction getDirection() {
        return direction;
    }

    public boolean wallDetected() {
        return true;
    }

    public void turnLeft() {
    }
    public void turnRight() {
    }
    public void moveForward() {
        position = position.add(direction.getVecteurDeplacement());
    }
    public static void readProgram() {
    }
    public void ececuteProgram() {
    }
    public void setPosition(Vecteur position) {
        this.position = position;
    }
}
