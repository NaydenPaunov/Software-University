package app;

import app.dtos.EmployeeDTO;
import app.dtos.ManagerDTO;
import app.entities.Employee;
import app.repositories.AddressRepository;
import app.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private AddressRepository addressRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public ConsoleRunner(AddressRepository addressRepository, EmployeeRepository employeeRepository) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        /* exr 1*/
        Employee one = this.employeeRepository.findOne(1L);
        ModelMapper mapper = new ModelMapper();
        EmployeeDTO dto = mapper.map(one,EmployeeDTO.class);

        System.out.println(dto.getFirstName());

        /* exr 2 */
        ManagerDTO managerDTO = mapper.map(one,ManagerDTO.class);

        for (EmployeeDTO  e : managerDTO.getServents()){
            System.out.printf("%s %s %.2f %n",e.getFirstName(),e.getLastName(),e.getSalary());
        }

        /* exr 3 */
        List<Employee> employees = this.employeeRepository.findByBirthDateBeforeOrderBySalaryDesc(LocalDate.parse("1990-01-01"));

        for (Employee e : employees){
            System.out.print(e.getFirstName() + " " + e.getLastName() + " " + e.getSalary() + " - ");
            String managerName = e.getManager() == null ? " [no manager]" : e.getManager().getFirstName();
            System.out.println(" Manager : " + managerName);
        }
    }
}
