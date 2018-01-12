package soft_uni.car_dealer_exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.car_dealer_exercise.MappingUtil;
import soft_uni.car_dealer_exercise.domain.dto.PartDto;
import soft_uni.car_dealer_exercise.domain.dto.SupplierDto;
import soft_uni.car_dealer_exercise.domain.dto.root.PartRootDto;
import soft_uni.car_dealer_exercise.domain.model.Part;
import soft_uni.car_dealer_exercise.domain.model.Supplier;
import soft_uni.car_dealer_exercise.repositories.PartRepository;
import soft_uni.car_dealer_exercise.repositories.SupplierRepository;
import soft_uni.car_dealer_exercise.service.api.PartService;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private PartRepository partRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository,
                           SupplierRepository supplierRepository) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void createMany(PartRootDto dtos) {
        List<Supplier> suppliers = (List<Supplier>) this.supplierRepository.findAll();
        for (PartDto dto : dtos.getParts()) {
            this.create(dto, this.getRandomSupplier(suppliers));
        }
    }

    private Supplier getRandomSupplier(List<Supplier> list){
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    @Override
    public void create(PartDto dto, Supplier supplier) {
        Part part = MappingUtil.convert(dto, Part.class);
        part.setSupplier(supplier);
        this.partRepository.save(part);
    }

    public List<Part> getAll(){
        List<Part> parts = (List<Part>) this.partRepository.findAll();
        return (List<Part>) this.partRepository.findAll();
    }
}
