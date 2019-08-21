package se.miknel.services;

import org.springframework.stereotype.Service;
import se.miknel.model.Worker;
import se.miknel.repositories.WorkerRepository;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService{

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker findById(Long aLong) {
        return workerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Worker save(Worker object) {
        return workerRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        workerRepository.deleteById(aLong);
    }

    @Override
    public Worker findByFirstName(String firstName) {
        return workerRepository.findByFirstName(firstName);
    }

    @Override
    public boolean existsByTelephoneNumber(String telephoneNumber) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

}
