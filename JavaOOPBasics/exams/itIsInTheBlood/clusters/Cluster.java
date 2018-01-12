package exam.clusters;

import exam.cells.Cell;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(this.cells);
    }

    public void addCell(Cell cell){
        if(cell.getHealth() > 0){
            this.cells.add(cell);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----Cluster ").append(this.getId()).append(System.lineSeparator());
        Comparator<Cell> byRow = Comparator.comparing(Cell::getPositionRow);
        Comparator<Cell> byCol = Comparator.comparing(Cell::getPositionCol);
        List<Cell> sorted = this.cells.stream().sorted(byRow.thenComparing(byCol)).collect(Collectors.toList());
        for (Cell cell : sorted) {
            sb.append(cell.toString());
        }
        return sb.toString();
    }
}
