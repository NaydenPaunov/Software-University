package app.exam.controller;

import app.exam.domain.dto.json.EmployeeJSONImportDTO;
import app.exam.domain.dto.json.EmployeeOrdersJSONExportDTO;
import app.exam.parser.interfaces.Parser;
import app.exam.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    @Qualifier(value = "JSONParser")
    private Parser jsonParser;


    public String importDataFromJSON(String jsonContent){
        EmployeeJSONImportDTO[] employeeJSONImportDTO = null;
        try {
            employeeJSONImportDTO = this.jsonParser.read(EmployeeJSONImportDTO[].class,jsonContent);
        }catch (Exception e){
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        for (EmployeeJSONImportDTO jsonImportDTO : employeeJSONImportDTO) {
            try {
                this.employeeService.create(jsonImportDTO);
                sb.append(String.format("Record %s successfully imported.",jsonImportDTO.getName()));
                sb.append(System.lineSeparator());
            }catch (Exception e){
                sb.append(String.format("Error: Invalid data."));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
