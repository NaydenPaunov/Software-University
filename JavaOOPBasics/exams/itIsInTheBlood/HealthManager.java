package exam;

import exam.cells.Cell;
import exam.cells.bloodCell.BloodCell;
import exam.cells.bloodCell.RedBloodCell;
import exam.cells.bloodCell.WhiteBloodCell;
import exam.cells.microbe.Bacteria;
import exam.cells.microbe.Fungi;
import exam.cells.microbe.Microbe;
import exam.cells.microbe.Virus;
import exam.clusters.Cluster;
import exam.organisms.Organism;

import java.util.*;
import java.util.stream.Collectors;

public class HealthManager {

    private Map<String,Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public 	String checkCondition(String organismName){
        if(this.organisms.containsKey(organismName)){
            return this.organisms.get(organismName).toString();
        }else{
            return "";
        }
    }

    public String createOrganism(String name) {
        Organism organism = new Organism(name);
        if(!this.organisms.containsKey(name)){
            this.organisms.put(name, organism);
            return String.format("Created organism %s",name);
        }else{
            return String.format("Organism %s already exists",name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols){
        Cluster cluster = new Cluster(id,rows,cols);
        if(this.organisms.containsKey(organismName) &&
                !this.organisms.get(organismName).getClusters().containsKey(id)){
            Organism organism = this.organisms.get(organismName);
            organism.addCluster(id, cluster);
            return String.format("Organism %s Created cluster %s",organismName,id);
        }
        return "";
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        if(!this.organisms.containsKey(organismName) || !this.organisms.get(organismName).getClusters().containsKey(clusterId)){
            return "";
        }else {
            int clusterRow = this.organisms.get(organismName).getClusters().get(clusterId).getRows();
            int clusterCol = this.organisms.get(organismName).getClusters().get(clusterId).getCols();
            if ((positionRow > clusterRow - 1 || positionRow < 0) || ( positionCol > clusterCol - 1 || positionCol < 0)) {
                return "";
            }
        }

        switch (cellType){
            case "WhiteBloodCell":
                    Cell whiteBloodCell = new WhiteBloodCell(cellId,health,positionRow,positionCol,additionalProperty);
                    this.organisms.get(organismName).getClusters().get(clusterId).addCell(whiteBloodCell);
                    break;
            case "RedBloodCell ":
                Cell redBloodCell = new RedBloodCell(cellId,health,positionRow,positionCol,additionalProperty);
                this.organisms.get(organismName).getClusters().get(clusterId).addCell(redBloodCell);
                break;
            case "Virus":
                Microbe virus = new Virus(cellId,health,positionRow,positionCol,additionalProperty);
                this.organisms.get(organismName).getClusters().get(clusterId).addCell(virus);
                break;
            case "Fungi":
                Microbe fungi = new Fungi(cellId,health,positionRow,positionCol,additionalProperty);
                this.organisms.get(organismName).getClusters().get(clusterId).addCell(fungi);
                break;
            case "Bacteria":
                Microbe bacteria = new Bacteria(cellId,health,positionRow,positionCol,additionalProperty);
                this.organisms.get(organismName).getClusters().get(clusterId).addCell(bacteria);
                break;
        }

        return String.format("Organism %s Created cell %s in cluster %s",organismName,cellId,clusterId);
    }

    public String activateCluster(String organismName) {

        if (!this.organisms.containsKey(organismName) || this.organisms.get(organismName).getClusters().size() < 1) {
            return "";
        }
        String clusterName = "";
        try {
            for (Cluster cluster : this.organisms.get(organismName).getClusters().values()) {
                clusterName = cluster.getId();
                Comparator<Cell> byRow = Comparator.comparing(Cell::getPositionRow);
                Comparator<Cell> byCol = Comparator.comparing(Cell::getPositionCol);
                List<Cell> sorted = cluster.getCells().stream().sorted(byRow.thenComparing(byCol)).collect(Collectors.toList());
                for (int i = 1; i < sorted.size(); i++) {
                    if (sorted.get(0) instanceof BloodCell) {
                        sorted.get(0).setHealth(sorted.get(0).getHealth() + sorted.get(i).getHealth());
                        sorted.get(0).setPositionRow(sorted.get(i).getPositionRow());
                        sorted.get(0).setPositionCol(sorted.get(i).getPositionCol());
                    } else {
                        while (true) {
                            sorted.get(i).setHealth(sorted.get(i).getHealth() - sorted.get(0).calculateEnergy());
                            if (sorted.get(i).getHealth() <= 0) {
                                sorted.get(0).setPositionRow(sorted.get(i).getPositionRow());
                                sorted.get(0).setPositionCol(sorted.get(i).getPositionCol());
                                break;
                            }
                            sorted.get(0).setHealth(sorted.get(0).getHealth() - sorted.get(i).calculateEnergy());
                            if (sorted.get(0).getHealth() <= 0) {
                                sorted.set(0, sorted.get(i));
                                break;
                            }
                        }
                    }
                }
                cluster.getCells().clear();
                cluster.addCell(sorted.get(0));
                break;
            }
        } catch (Exception e){}
        Cluster cluster = this.organisms.get(organismName).getClusters().get(clusterName);
        this.organisms.get(organismName).getClusters().remove(clusterName);
        this.organisms.get(organismName).getClusters().putIfAbsent(clusterName, cluster);
        int size = cluster.getCells().size();
        return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, cluster.getId(), size);
    }

}
