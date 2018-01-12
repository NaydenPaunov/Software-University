package exam.cells;

public abstract class Cell {

    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.setHealth(health);
        this.setPositionRow(positionRow);
        this.setPositionCol(positionCol);
    }

    public abstract int calculateEnergy();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
            this.health = health;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
            this.positionRow = positionRow;
    }


    public int getPositionCol() {
        return positionCol;
    }

    public void setPositionCol(int positionCol){
            this.positionCol = positionCol;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
