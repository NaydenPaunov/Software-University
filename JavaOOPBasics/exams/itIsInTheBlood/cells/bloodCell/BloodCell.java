package exam.cells.bloodCell;

import exam.cells.Cell;

public abstract class BloodCell extends Cell{

    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------Cell ").append(super.getId())
                .append(String.format(" [%d,%d]", super.getPositionRow(), super.getPositionCol())).append(System.lineSeparator());

        return sb.toString();
    }
}
