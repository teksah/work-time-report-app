package se.miknel.worktimereportapp.model;

import java.time.LocalDate;
import java.util.Set;

public class Project extends BaseEntity{
    private String description;
    private Address address;
    private Customer customer;
    private LocalDate projectStart;
    private LocalDate projectFinish;
    private Set<Worker> workers;
}
