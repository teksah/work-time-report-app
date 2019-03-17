package se.miknel.worktimereportapp.model;

import java.util.HashSet;
import java.util.Set;

public class Project extends BaseEntity{
    private String projectName;
    private String streetName;
    private String zipCode;
    private String city;
    private Set<Worker> workers = new HashSet<>();
}
