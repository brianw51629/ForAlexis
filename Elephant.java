import java.awt.Color;

public class Elephant extends Critter {
    protected int goalX = 0;
    protected int goalY = 0;

    public Elephant() {
        super("El");
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public Direction getMove() {
        if (info.getX() == goalX && info.getY() == goalY) {
            goalX = random.nextInt(info.getWidth());
            goalY = random.nextInt(info.getHeight());
        }
        if (Math.abs(info.getX() - goalX) > Math.abs(info.getY() - goalY)) {
            return info.getX() < goalX ? Direction.EAST : Direction.WEST;
        } else {
            return info.getY() < goalY ? Direction.SOUTH : Direction.NORTH;
        }
    }

    @Override
    public boolean eat() {
        return true;
    }

    @Override
    public void mate() {
        // Implement level increment
    }

    @Override
    public void reset() {
        goalX = 0;
        goalY = 0;
    }
}
