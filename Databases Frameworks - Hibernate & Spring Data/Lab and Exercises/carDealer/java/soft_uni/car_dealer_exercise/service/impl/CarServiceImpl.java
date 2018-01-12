package soft_uni.car_dealer_exercise.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.car_dealer_exercise.MappingUtil;
import soft_uni.car_dealer_exercise.domain.dto.CarDto;
import soft_uni.car_dealer_exercise.domain.dto.PartDto;
import soft_uni.car_dealer_exercise.domain.dto.output.CarOutputDto;
import soft_uni.car_dealer_exercise.domain.dto.root.CarRootDto;
import soft_uni.car_dealer_exercise.domain.dto.root.PartRootDto;
import soft_uni.car_dealer_exercise.domain.model.Car;
import soft_uni.car_dealer_exercise.domain.model.Customer;
import soft_uni.car_dealer_exercise.domain.model.Part;
import soft_uni.car_dealer_exercise.repositories.CarRepository;
import soft_uni.car_dealer_exercise.repositories.CustomerRepository;
import soft_uni.car_dealer_exercise.repositories.PartRepository;
import soft_uni.car_dealer_exercise.service.api.CarService;

import java.util.*;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private CustomerRepository customerRepository;
    private PartRepository partRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          CustomerRepository customerRepository,
                          PartRepository partRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.partRepository = partRepository;
    }


    @Override
    public void createMany(CarRootDto dto) {
        List<Customer> customers = (List<Customer>)this.customerRepository.findAll();
        List<Part> parts = (List<Part>) this.partRepository.findAll();
//        for (CarDto carDto: dto.getCars()) {
//            this.create(carDto, this.getRandomCustomer(customers),
//                    this.getRandomParts(parts));
//        }
    }

    private void create(CarDto dto, Customer customer, Set<Part> parts){
        Car car = MappingUtil.convert(dto, Car.class);
        car.setParts(parts);
        car.setOwner(customer);
        this.carRepository.save(car);
    }
    private Customer getRandomCustomer(List<Customer> customers){
        Random random = new Random();
        int index = random.nextInt(customers.size());
        return customers.get(index);
    }
    private Set<Part> getRandomParts(List<Part> parts){
        Set<Part> randomParts = new HashSet<>();
        for(int i = 0; i < 20; i++){
            randomParts.add((Part) this.getRandom(parts));
        }
        return randomParts;
    }

    private Object getRandom(List<Part> list){
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    @Override
    public List<CarOutputDto> getAllByMake(String make){
        List<Car> carsByMake = this.carRepository.getAllByMake(make);
        return MappingUtil.convert(carsByMake, CarOutputDto.class);
    }

    @Override
    public List<CarOutputDto> getAllWithParts(){
        List<Car> cars = (List<Car>) this.carRepository.findAll();
        List<CarOutputDto> result = new ArrayList<>();
        for (Car car : cars) {
            PartRootDto partRootDto = new PartRootDto();
            Set<PartDto> partDtos = MappingUtil.convert(car.getParts(), PartDto.class);
            partRootDto.setParts(partDtos);
            CarOutputDto carOutputDto = MappingUtil.convert(car, CarOutputDto.class);
            carOutputDto.setParts(partRootDto);
            result.add(carOutputDto);
        }
        return result;
    }
}
