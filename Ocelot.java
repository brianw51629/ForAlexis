import java.awt.Color;

public class Ocelot extends Leopard {
    public Ocelot() {
        super();
        super.displayName = "Oce";
    }

    @Override
    public Color getColor() {
        return Color.LIGHT_GRAY;
    }

    @Override
    protected Attack generateAttack(String opponent) {
        if (opponent.equals("Lion") || opponent.equals("Feline") || opponent.equals("Leopard")) {
            return Attack.SCRATCH;
        } else {
            return Attack.POUNCE;
        }
    }
}
