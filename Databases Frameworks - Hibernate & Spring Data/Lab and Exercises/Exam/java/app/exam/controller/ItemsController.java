package app.exam.controller;

import app.exam.domain.dto.json.ItemJSONImportDTO;
import app.exam.parser.interfaces.Parser;
import app.exam.service.api.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @Autowired
    @Qualifier(value = "JSONParser")
    private Parser jsonParser;


    public String importDataFromJSON(String jsonContent) {
        ItemJSONImportDTO[] itemJSONImportDTOS = null;
        try {
            itemJSONImportDTOS = this.jsonParser.read(ItemJSONImportDTO[].class,jsonContent);
        }catch (Exception e){
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        for (ItemJSONImportDTO jsonImportDTO : itemJSONImportDTOS) {
            try {
                this.itemsService.create(jsonImportDTO);
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
