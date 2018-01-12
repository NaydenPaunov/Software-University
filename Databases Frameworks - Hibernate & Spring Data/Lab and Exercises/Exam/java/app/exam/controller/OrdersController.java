package app.exam.controller;

import app.exam.domain.dto.json.EmployeeOrdersJSONExportDTO;
import app.exam.domain.dto.xml.OrderWrapperXMLImportDTO;
import app.exam.domain.dto.xml.OrderXMLImportDTO;
import app.exam.parser.interfaces.Parser;
import app.exam.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class OrdersController {

    @Autowired
    @Qualifier(value = "XMLParser")
    private Parser xmlParser;


    @Autowired
    @Qualifier(value = "JSONParser")
    private Parser jsonParser;

    @Autowired
    private OrderService orderService;

    public String importDataFromXML(String xmlContent) {
        OrderWrapperXMLImportDTO orderWrapperXMLImportDTO = null;
        try {
            orderWrapperXMLImportDTO = this.xmlParser.read(OrderWrapperXMLImportDTO.class, xmlContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        for ( OrderXMLImportDTO orderXMLImportDTO : orderWrapperXMLImportDTO.getOrders()) {
            try{
                this.orderService.create(orderXMLImportDTO);
                sb.append(String.format("Order for %s on %s added.",
                        orderXMLImportDTO.getCustomer(),orderXMLImportDTO.getDate()));
                sb.append(System.lineSeparator());
            } catch (Exception e){
                sb.append(String.format("Error: Invalid data."));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String exportOrdersByEmployeeAndOrderType(String employeeName, String orderType) throws IOException, JAXBException {
        EmployeeOrdersJSONExportDTO employeeOrdersJSONExportDTO = this.orderService.exportOrdersByEmployeeAndOrderType(employeeName, orderType);
        String output = this.jsonParser.write(employeeOrdersJSONExportDTO);
        return output;
    }
}
