package se.miknel.worktimereportapp.services;

import se.miknel.worktimereportapp.model.Project;

public interface ProjectService extends CrudService<Project, Long> {

    boolean existsByAddress_StreetName(String address);

    boolean existsByProjectName(String name);

}
