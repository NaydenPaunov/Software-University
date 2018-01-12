package exam.cells.microbe;

import exam.cells.Cell;

public abstract class Microbe extends Cell {

    private int virulence;

    protected Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.setVirulence(virulence);
    }

    public int getVirulence() {
        return this.virulence;
    }

    private void setVirulence(int virulence) {
        if(virulence >= 0){
            this.virulence = virulence;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------Cell ").append(super.getId())
                .append(String.format(" [%d,%d]", super.getPositionRow(), super.getPositionCol())).append(System.lineSeparator());

        return sb.toString();
    }
}
