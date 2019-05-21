package se.miknel.worktimereportapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.miknel.worktimereportapp.model.*;
import se.miknel.worktimereportapp.services.*;

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

    public DataLoader(WorkerService workerService, CustomerService customerService, ProjectService projectService, ReportService reportService, UnitOfRestService unitOfRestService) {
        this.workerService = workerService;
        this.customerService = customerService;
        this.projectService = projectService;
        this.reportService = reportService;
        this.unitOfRestService = unitOfRestService;
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
        Project project4 = new Project("Lustro Lazienka", address4, customer3, false);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);
        projectService.save(project4);

        Worker worker1 = new Worker("Sebastian", "Bakowski");
        Worker worker2 = new Worker("Sebastianek", "Gaciarz");
        Worker worker3 = new Worker("Mariusz", "Gaciarz");

        worker1.addProject(project1);
        worker1.addProject(project3);
        worker1.addProject(project4);

        worker2.addProject(project1);
        worker2.addProject(project3);

        worker3.addProject(project2);
        worker3.addProject(project3);

        workerService.save(worker1);
        workerService.save(worker2);
        workerService.save(worker3);

        Report report1 = new Report(worker1, LocalDate.of(2019, 3, 22), project1, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(0)), "rywning grund");
        report1.calculateTotalHours();

        Report report2 = new Report(worker2, LocalDate.of(2019, 3, 22), project1, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(0.5)), "rywning grund");
        report2.calculateTotalHours();

        Report report3 = new Report(worker3, LocalDate.of(2019, 3, 25), project2, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(1)), "kompletowanie");
        report3.calculateTotalHours();

        Report report4 = new Report(worker1, LocalDate.of(2019, 3, 27), project3, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(0)), "spotkanie");
        report4.calculateTotalHours();

        Report report5 = new Report(worker2, LocalDate.of(2019, 3, 27), project3, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(1)), "spotkanie");
        report5.calculateTotalHours();

        Report report6 = new Report(worker3, LocalDate.of(2019, 3, 27), project3, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(1)), "spotkanie");
        report6.calculateTotalHours();

        Report report7 = new Report(worker1, LocalDate.of(2019, 3, 28), project4, LocalTime.of(7, 0), LocalTime.of(16, 0), unitOfRestService.findByValue(BigDecimal.valueOf(1)), "grund");
        report7.calculateTotalHours();


        reportService.save(report1);
        reportService.save(report2);
        reportService.save(report3);
        reportService.save(report4);
        reportService.save(report5);
        reportService.save(report6);
        reportService.save(report7);







    }
}
