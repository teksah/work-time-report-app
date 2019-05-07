package se.miknel.worktimereportapp.services;

import org.springframework.stereotype.Service;
import se.miknel.worktimereportapp.model.Project;
import se.miknel.worktimereportapp.repositories.ProjectRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Set<Project> findAll() {
        Set<Project> projects = new HashSet<>();

        projectRepository.findAll().iterator().forEachRemaining(projects::add);

        return projects;
    }

    @Override
    public Project findById(Long aLong) {
        return projectRepository.findById(aLong).orElse(null);
    }

    @Override
    public Project save(Project object) {
        return projectRepository.save(object);
    }

    @Override
    public void delete(Project object) {
        projectRepository.delete(object);
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
