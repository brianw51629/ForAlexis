import java.awt.Color;

public class CustomCritter extends Critter {
    private int winCount = 0;

    public CustomCritter() {
        super();
        super.displayName = "Tiger";
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public Direction getMove() {
        Direction[] directions = { Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST };
        return directions[random.nextInt(directions.length)];
    }

    @Override
    public boolean eat() {
        return winCount >= 2;
    }

    @Override
    public void win() {
        winCount++;
    }

    @Override
    public void lose() {
        winCount = 0;
    }

    @Override
    public Attack getAttack(String opponent) {
        // You can customize the attack behavior here if needed
        return super.getAttack(opponent);
    }
}
