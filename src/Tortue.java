
public class Tortue {

    private Vecteur position;
    private Direction direction;

    public Tortue(Vecteur position) {
        this.position = position;
        this.direction = Direction.Nord;
    }

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
    }
    public static void readProgram() {
    }
    public void ececuteProgram() {
    }
    public void setPosition(int x, int y){
        position = new Vecteur(x, y);
    }
}
