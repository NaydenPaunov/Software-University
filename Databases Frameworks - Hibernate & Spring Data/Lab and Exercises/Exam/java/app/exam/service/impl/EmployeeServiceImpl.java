package app.exam.service.impl;

import app.exam.domain.dto.json.EmployeeJSONImportDTO;
import app.exam.domain.entities.Employee;
import app.exam.domain.entities.Position;
import app.exam.parser.ValidationUtil;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.EmployeeRepository;
import app.exam.repository.PositionRepository;
import app.exam.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(EmployeeJSONImportDTO importDTO) {
        Employee employee = this.modelParser.convert(importDTO,Employee.class);

        String positionName = importDTO.getPosition();
        Position position = this.positionRepository.findByName(positionName);
        if(position != null){
            employee.setPosition(position);
        }else if(position == null){
            Position newPosition = new Position();
            newPosition.setName(positionName);

            if(ValidationUtil.isValid(newPosition)){
                employee.setPosition(newPosition);
                if(!ValidationUtil.isValid(employee)) {
                    throw new IllegalArgumentException("Employee not Valid");
                }
                positionRepository.saveAndFlush(newPosition);

            }else {
                throw new IllegalArgumentException("Position not Valid");
            }
        }
        this.employeeRepository.save(employee);
    }

    @Override
    public void createMany(EmployeeJSONImportDTO[] importDTO) {

    }
}
