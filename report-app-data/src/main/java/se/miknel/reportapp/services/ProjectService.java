package se.miknel.reportapp.services;

import se.miknel.reportapp.model.Project;

import java.util.Set;

public interface ProjectService extends CrudService<Project, Long> {

    boolean existsByAddress_StreetName(String address);

    boolean existsByProjectName(String name);

    Set<Project> findAll(boolean active);
}
