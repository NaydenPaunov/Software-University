package exam.cells.microbe;

public class Fungi extends Microbe {

    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int calculateEnergy() {
        return ((super.getHealth() + super.getVirulence()) / 4);
    }

    @Override
    public String toString() {
        return String.format("%s--------Health %d | Size %d | Energy %d%n", super.toString(),
                super.getHealth(),super.getVirulence(),this.calculateEnergy());
    }
}
