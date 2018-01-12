package soft_uni.car_dealer_exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.car_dealer_exercise.MappingUtil;
import soft_uni.car_dealer_exercise.domain.dto.SupplierDto;
import soft_uni.car_dealer_exercise.domain.dto.root.PartRootDto;
import soft_uni.car_dealer_exercise.domain.model.Supplier;
import soft_uni.car_dealer_exercise.repositories.SupplierRepository;
import soft_uni.car_dealer_exercise.service.api.SupplierService;

import javax.transaction.Transactional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void create(SupplierDto dto) {
        Supplier supplier = MappingUtil.convert(dto, Supplier.class);
        this.supplierRepository.save(supplier);
    }
}
