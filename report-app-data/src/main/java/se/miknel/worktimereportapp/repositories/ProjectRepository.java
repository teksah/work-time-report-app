package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Project;
import se.miknel.worktimereportapp.model.Report;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
