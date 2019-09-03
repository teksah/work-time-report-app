package se.miknel.services;

import org.springframework.stereotype.Service;
import se.miknel.exceptions.NotFoundException;
import se.miknel.model.WorkerType;
import se.miknel.repositories.WorkerTypeRepository;

import java.util.List;

@Service
public class WorkerTypeServiceImpl implements WorkerTypeService {

    private final WorkerTypeRepository workerTypeRepository;

    public WorkerTypeServiceImpl(WorkerTypeRepository workerTypeRepository) {
        this.workerTypeRepository = workerTypeRepository;
    }

    @Override
    public List<WorkerType> findAll() {
        return workerTypeRepository.findAll();
    }

    @Override
    public WorkerType findById(Long aLong) {
        return workerTypeRepository.findById(aLong).orElseThrow(NotFoundException::new);
    }

    @Override
    public WorkerType save(WorkerType object) {
        return workerTypeRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        workerTypeRepository.findById(aLong);
    }
}
