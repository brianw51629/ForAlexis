import java.awt.Color;

public class Turtle extends Critter {
    public Turtle() {
        super("Tu");
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public Direction getMove() {
        return Direction.WEST;
    }

    @Override
    public boolean eat() {
        // Check for hostile animals in adjacent cells
        return !(info.getNeighbor(Direction.NORTH).equals(" ")
                || info.getNeighbor(Direction.SOUTH).equals(" ")
                || info.getNeighbor(Direction.EAST).equals(" ")
                || info.getNeighbor(Direction.WEST).equals(" "));
    }

    @Override
    public Attack getAttack(String opponent) {
        return random.nextBoolean() ? Attack.ROAR : Attack.FORFEIT;
    }
}
