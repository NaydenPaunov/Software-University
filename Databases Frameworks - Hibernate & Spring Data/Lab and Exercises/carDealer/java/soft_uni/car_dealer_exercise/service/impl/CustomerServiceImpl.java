package soft_uni.car_dealer_exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.car_dealer_exercise.MappingUtil;
import soft_uni.car_dealer_exercise.domain.dto.CustomerDto;
import soft_uni.car_dealer_exercise.domain.model.Customer;
import soft_uni.car_dealer_exercise.repositories.CustomerRepository;
import soft_uni.car_dealer_exercise.service.api.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void create(CustomerDto dto) {
        Customer customer = MappingUtil.convert(dto, Customer.class);
        this.customerRepository.save(customer);
    }
}
