package app.exam.domain.entities;

public enum OrderType {
    FORHERE(0),
    TOGO(1);

    private int value;

    OrderType(final int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
