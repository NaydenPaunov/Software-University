package exam.cells.bloodCell;

public class WhiteBloodCell extends BloodCell {

    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol,int size) {
        super(id, health, positionRow, positionCol);
        this.setSize(size);
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        if(size >= 0) {
        this.size = size;
        }
    }

    @Override
    public int calculateEnergy() {
        return ((this.getSize() + super.getHealth())* 2);
    }

    @Override
    public String toString() {
        return String.format("%s--------Health %d | Size %d | Energy %d%n", super.toString(),
                super.getHealth(),this.getSize(),this.calculateEnergy());
    }
}
