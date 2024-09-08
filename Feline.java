
public class Feline extends Critter {
    private int moveCount = 0;
    private int eatCount = 0;
    private Direction currDir = Direction.NORTH;

    public Feline() {
        super("Fe");
    }

    @Override
    public Direction getMove() {
        moveCount++;
        if (moveCount % 5 == 0) {
            currDir = Direction.values()[random.nextInt(Direction.values().length - 2)]; // Random direction excluding CENTER
        }
        return currDir;
    }

    @Override
    public boolean eat() {
        eatCount++;
        return eatCount % 3 == 0;
    }

    @Override
    public Attack getAttack(String opponent) {
        return Attack.POUNCE;
    }
}
