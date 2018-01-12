package app.dtos;

import java.util.List;

public class ManagerDTO extends NamedDTO {

    private List<EmployeeDTO> servents;

    public List<EmployeeDTO> getServents() {
        return servents;
    }

    public void setServents(List<EmployeeDTO> servents) {
        this.servents = servents;
    }
}
