package exam.organisms;

import exam.clusters.Cluster;
import javafx.beans.binding.StringBinding;

import java.util.*;

public class Organism {

    private String name;
    private Map<String,Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
    }

    public Map<String, Cluster> getClusters() {
        return this.clusters;
    }

    public void addCluster(String id, Cluster cluster) {
        this.clusters.put(id, cluster);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organism - ").append(this.name).append(System.lineSeparator());
        sb.append("--Clusters: ").append(this.clusters.size()).append(System.lineSeparator());
        int cellCount = 0;
        for (Cluster cluster : this.clusters.values()) {
            cellCount += cluster.getCells().size();
        }
        sb.append("--Cells: ").append(cellCount).append(System.lineSeparator());
        for (Cluster cluster : this.clusters.values()) {
            sb.append(cluster.toString());
        }
        return sb.toString();
    }
}
