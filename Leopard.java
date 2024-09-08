import java.awt.Color;

public class Leopard extends Feline {
    protected static int confidence = 0;

    public Leopard() {
        super();
        super.displayName = "Lpd";
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    
@Override
public Direction getMove() {
    System.out.println("getMove() called");

    // Assuming Direction values are in the correct order: NORTH, SOUTH, EAST, WEST
    String[] neighbors = {
        info.getNeighbor(Direction.NORTH),
        info.getNeighbor(Direction.SOUTH),
        info.getNeighbor(Direction.EAST),
        info.getNeighbor(Direction.WEST)
    };

    System.out.println("Neighbors length: " + neighbors.length);

    // Check valid moves
    for (Direction direction : Direction.values()) {
        if (direction == Direction.CENTER) continue; // Skip CENTER
        
        int index = direction.ordinal();
        if (index < neighbors.length &&
            (neighbors[index].equals(".") || neighbors[index].equals("Starfish"))) {
            return direction;
        }
    }

    // Randomly choose a direction excluding CENTER
    Direction randomDirection;
    do {
        randomDirection = Direction.values()[random.nextInt(Direction.values().length)];
    } while (randomDirection == Direction.CENTER);

    return randomDirection;
}




    @Override
    public boolean eat() {
        return random.nextInt(100) < (confidence * 10);
    }

    @Override
    public void win() {
        if (confidence < 10) {
            confidence++;
        }
    }

    @Override
    public void lose() {
        if (confidence > 0) {
            confidence--;
        }
    }

    @Override
    public Attack getAttack(String opponent) {
        if (opponent.equals("Turtle") || confidence > 5) {
            return Attack.POUNCE;
        } else {
            return generateAttack(opponent);
        }
    }

    protected Attack generateAttack(String opponent) {
        if (opponent.equals("Starfish")) {
            return Attack.FORFEIT;
        }
        return Attack.values()[random.nextInt(3)]; // Randomly choose between POUNCE, SCRATCH, ROAR
    }

    @Override
    public void reset() {
        confidence = 0;
    }
}
