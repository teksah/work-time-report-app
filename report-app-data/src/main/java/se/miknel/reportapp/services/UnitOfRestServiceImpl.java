package se.miknel.reportapp.services;

import org.springframework.stereotype.Service;
import se.miknel.reportapp.model.UnitOfRest;
import se.miknel.reportapp.repositories.UnitOfRestRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class UnitOfRestServiceImpl implements UnitOfRestService {

    private final UnitOfRestRepository unitOfRestRepository;

    public UnitOfRestServiceImpl(UnitOfRestRepository unitOfRestRepository) {
        this.unitOfRestRepository = unitOfRestRepository;
    }

    @Override
    public Set<UnitOfRest> findAll() {

        Set<UnitOfRest> unitOfRests = new HashSet<>();

        unitOfRestRepository.findAll().iterator().forEachRemaining(unitOfRests::add);

        return unitOfRests;
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
    public void delete(UnitOfRest object) {
        unitOfRestRepository.delete(object);
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
