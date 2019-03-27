package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}