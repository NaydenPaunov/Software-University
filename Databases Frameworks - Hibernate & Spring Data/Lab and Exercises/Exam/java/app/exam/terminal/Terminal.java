package app.exam.terminal;

import app.exam.config.Config;
import app.exam.controller.EmployeesController;
import app.exam.controller.ItemsController;
import app.exam.controller.OrdersController;
import app.exam.io.interfaces.ConsoleIO;
import app.exam.io.interfaces.FileIO;
import app.exam.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {
    @Autowired
    private FileIO fileParser;

    @Autowired
    private ConsoleIO consoleIO;

    @Autowired
    private EmployeesController employeesController;

    @Autowired
    private ItemsController itemsController;

    @Autowired
    private OrdersController ordersController;

    @Autowired
    private OrderService orderService;


    @Override
    public void run(String... args) throws Exception {
//        this.consoleIO.write(this.employeesController.importDataFromJSON(this.fileParser.read(Config.EMPLOYEES_IMPORT_JSON)));
//        this.consoleIO.write(this.itemsController.importDataFromJSON(this.fileParser.read(Config.ITEMS_IMPORT_JSON)));
//        this.consoleIO.write(this.ordersController.importDataFromXML(this.fileParser.read(Config.ORDERS_IMPORT_XML)));

        this.consoleIO.write(this.ordersController.exportOrdersByEmployeeAndOrderType("Avery Rush", "ToGo"));

    }
}
