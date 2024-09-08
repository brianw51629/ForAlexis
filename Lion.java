import java.awt.Color;

public class Lion extends Feline {
    private int winCount = 0;
    private Direction[] movePattern = {Direction.EAST, Direction.EAST, Direction.EAST, Direction.EAST, Direction.EAST,
                                       Direction.SOUTH, Direction.SOUTH, Direction.SOUTH, Direction.SOUTH, Direction.SOUTH,
                                       Direction.WEST, Direction.WEST, Direction.WEST, Direction.WEST, Direction.WEST,
                                       Direction.NORTH, Direction.NORTH, Direction.NORTH, Direction.NORTH, Direction.NORTH};
    private int moveIndex = 0;

    public Lion() {
        super();
        super.displayName = "Lion";
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    public Direction getMove() {
        Direction move = movePattern[moveIndex];
        moveIndex = (moveIndex + 1) % movePattern.length;
        return move;
    }

    @Override
    public boolean eat() {
        return winCount > 0;
    }

    @Override
    public void sleep() {
        winCount = 0;
        super.displayName = "noiL";
    }

    @Override
    public void wakeup() {
        super.displayName = "Lion";
    }

    @Override
    public void win() {
        winCount++;
    }

    @Override
    public Attack getAttack(String opponent) {
        return super.getAttack(opponent); // Inherits Feline's behavior
    }
}
