package se.miknel.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.miknel.model.*;
import se.miknel.services.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {
    private final WorkerService workerService;
    private final CustomerService customerService;
    private final ProjectService projectService;
    private final ReportService reportService;
    private final UnitOfRestService unitOfRestService;
    private final WorkerTypeService workerTypeService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public DataLoader(WorkerService workerService, CustomerService customerService, ProjectService projectService, ReportService reportService, UnitOfRestService unitOfRestService, WorkerTypeService workerTypeService, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.workerService = workerService;
        this.customerService = customerService;
        this.projectService = projectService;
        this.reportService = reportService;
        this.unitOfRestService = unitOfRestService;
        this.workerTypeService = workerTypeService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer customer1 = new Customer("Jan", "Fasola", "0735787921", "fasola@fasola.com");
        Customer customer2 = new Customer("Pawel", "Gawel", "0725787984", "gawel@gawel.com");
        Customer customer3 = new Customer("Pawel", "Wasill", "0735283926", "pawel@wasillbygg.com");

        customerService.save(customer1);
        customerService.save(customer2);
        customerService.save(customer3);

        Address address1 = new Address("Centrum 12", "12345", "Stockholm");
        Address address2 = new Address("Alvsio 6", "11122", "Alvsio");
        Address address3 = new Address("Huddinge 34", "55555", "Huddinge");
        Address address4 = new Address("Lidingovagen 69", "68669", "Lidingo");

        Project project1 = new Project("Mieszkanie Centrum", address1, customer1, true);
        Project project2 = new Project("Block Alvsio", address2, customer1, true);
        Project project3 = new Project("Remont Pokoju", address3, customer2, true);
        Project project4 = new Project("Lustro Lazienka", address4, customer3, true);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);
        projectService.save(project4);


        WorkerType electrician = workerTypeService.findById(3l);
        Role user = new Role("ROLE_USER");
        roleService.save(user);

        Worker antoni = new Worker("Antoni", "Parasolowicz", "1234567890", "parasol@parasol.pl", electrician, "antoni", passwordEncoder.encode("antoni"));
        antoni.addRole(user);
        workerService.save(antoni);

        Report report1 = new Report(antoni, LocalDate.of(2019, 3, 22), project1, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(0)), "rywning grund");
        Report report2 = new Report(antoni, LocalDate.of(2019, 3, 22), project1, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(0.5)), "rywning grund");
        Report report3 = new Report(antoni, LocalDate.of(2019, 3, 25), project2, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(1)), "kompletowanie");
        Report report4 = new Report(antoni, LocalDate.of(2019, 3, 27), project3, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(0)), "spotkanie");
        Report report5 = new Report(antoni, LocalDate.of(2019, 3, 27), project3, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(1)), "spotkanie");
        Report report6 = new Report(antoni, LocalDate.of(2019, 3, 27), project3, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(1)), "spotkanie");
        Report report7 = new Report(antoni, LocalDate.of(2019, 3, 28), project4, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(1)), "grund");

        reportService.save(report1);
        reportService.save(report2);
        reportService.save(report3);
        reportService.save(report4);
        reportService.save(report5);
        reportService.save(report6);
        reportService.save(report7);







    }
}
