package se.miknel.services;

import org.springframework.stereotype.Service;
import se.miknel.model.UnitOfRest;
import se.miknel.repositories.UnitOfRestRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UnitOfRestServiceImpl implements UnitOfRestService {

    private final UnitOfRestRepository unitOfRestRepository;

    public UnitOfRestServiceImpl(UnitOfRestRepository unitOfRestRepository) {
        this.unitOfRestRepository = unitOfRestRepository;
    }

    @Override
    public List<UnitOfRest> findAll() {
        return unitOfRestRepository.findAll();
    }

    @Override
    public UnitOfRest findById(Long aLong) {
        return unitOfRestRepository.findById(aLong).orElse(null);
    }

    @Override
    public UnitOfRest save(UnitOfRest object) {
        return unitOfRestRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        unitOfRestRepository.deleteById(aLong);
    }

    @Override
    public UnitOfRest findByValue(BigDecimal value) {
        return unitOfRestRepository.findByValue(value);
    }

}
