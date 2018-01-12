package exam.cells.bloodCell;

public class RedBloodCell extends BloodCell {

    /*
        describes the speed of the cell
     */
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.setVelocity(velocity);
    }

    public int getVelocity() {
        return velocity;
    }



    private void setVelocity(int velocity) {
        if(velocity >= 0){
            this.velocity = velocity;
        }
    }

    @Override
    public int calculateEnergy() {
        return (this.getVelocity() + super.getHealth());
    }

    @Override
    public String toString() {
        return String.format("%s--------Health %d | Size %d | Energy %d%n", super.toString(),
                super.getHealth(),this.getVelocity(),this.calculateEnergy());
    }
}

