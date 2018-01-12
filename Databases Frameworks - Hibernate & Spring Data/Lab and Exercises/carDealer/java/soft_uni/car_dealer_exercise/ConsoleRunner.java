package soft_uni.car_dealer_exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import soft_uni.car_dealer_exercise.domain.dto.root.CarRootDto;
import soft_uni.car_dealer_exercise.service.api.CarService;
import soft_uni.car_dealer_exercise.service.api.CustomerService;
import soft_uni.car_dealer_exercise.service.api.PartService;
import soft_uni.car_dealer_exercise.service.api.SupplierService;
import soft_uni.car_dealer_exercise.service.impl.SupplierServiceImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private SupplierService supplierService;
    private PartService partService;
    private CustomerService customerService;
    private CarService carService;

    @Autowired
    public ConsoleRunner(SupplierServiceImpl supplierService,
                         PartService partService,
                         CustomerService customerService,
                         CarService carService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.customerService = customerService;
        this.carService = carService;
    }

    @Override
    public void run(String... args) throws Exception {
          JAXBContext context = JAXBContext.newInstance(CarRootDto.class);
          Marshaller marshaller = context.createMarshaller();
            File file = new File("E:\\Softuni\\SVN\\Databases\\Java Db Fundamentals 09-2017\\Database-Frameworks\\12. DB-Advanced-XML-Processing\\car_dealer_exercise\\src\\main\\resources\\files\\cars.xml");
//        SupplierRootDto suppliersDto = (SupplierRootDto) unmarshaller.unmarshal(file);
//        for (SupplierDto supplierDto : suppliersDto.getSupplierDtos()) {
//            this.supplierService.create(supplierDto);
//        }
        CarRootDto rootDto = new CarRootDto();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        rootDto.setCars(this.carService.getAllWithParts());
        File outputFile = new File("E:\\Softuni\\SVN\\Databases\\Java Db Fundamentals 09-2017\\Database-Frameworks\\12. DB-Advanced-XML-Processing\\car_dealer_exercise\\src\\main\\resources\\files\\output.xml");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        marshaller.marshal(rootDto, writer);
    }
}
