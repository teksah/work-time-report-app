package se.miknel.reportapp.services;

import org.springframework.stereotype.Service;
import se.miknel.reportapp.model.Worker;
import se.miknel.reportapp.repositories.WorkerRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class WorkerServiceImpl implements WorkerService{

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Set<Worker> findAll() {
        Set<Worker> workers = new HashSet<>();

        workerRepository.findAll().iterator().forEachRemaining(workers::add);

        return workers;
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
    public void delete(Worker object) {
        workerRepository.delete(object);
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
