package se.miknel.services;

import org.springframework.stereotype.Service;
import se.miknel.exceptions.NotFoundException;
import se.miknel.model.Project;
import se.miknel.repositories.ProjectRepository;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
   }

    @Override
    public Project findById(Long aLong) {
        return projectRepository.findById(aLong).orElseThrow(NotFoundException::new);
    }

    @Override
    public Project save(Project object) {
        return projectRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        projectRepository.deleteById(aLong);
    }

    @Override
    public boolean existsByAddress_StreetName(String address) {
        return projectRepository.existsByAddress_StreetName(address);
    }

    @Override
    public boolean existsByProjectName(String name) {
        return projectRepository.existsByProjectName(name);
    }


}
