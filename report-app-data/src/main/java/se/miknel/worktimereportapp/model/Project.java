package se.miknel.worktimereportapp.model;

import java.time.LocalDate;
import java.util.List;

public class Project extends BaseEntity{
    private String description;
    private String extraInfo;
    private Address address;
    private Customer customer;
    private LocalDate projectStart;
    private LocalDate projectFinish;
    private List<Worker> workers;
}
