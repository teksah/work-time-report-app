package se.miknel.worktimereportapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.miknel.worktimereportapp.model.*;
import se.miknel.worktimereportapp.services.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {
    private final WorkerService workerService;
    private final CustomerService customerService;
    private final AddressService addressService;
    private final ProjectService projectService;
    private final ReportService reportService;

    public DataLoader(WorkerService workerService, CustomerService customerService, AddressService addressService, ProjectService projectService, ReportService reportService) {
        this.workerService = workerService;
        this.customerService = customerService;
        this.addressService = addressService;
        this.projectService = projectService;
        this.reportService = reportService;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer customer1 = new Customer("Jan", "Fasola", "123456789", "Fasola AB", true, "fasola@fasola.com");
        Customer customer2 = new Customer("Pawel", "Gawel", "987654321", "gawel@gawel.com");
        Customer customer3 = new Customer("Pawel", "Wasill", "666666666", "WasillBygg", true, "pawel@wasillbygg.com");

        customerService.save(customer1);
        customerService.save(customer2);
        customerService.save(customer3);

        Address address1 = new Address("Centrum 12", "123-45", "Stockholm");
        Address address2 = new Address("Alvsio 6", "111-22", "Alvsio");
        Address address3 = new Address("Huddinge 34", "555-55", "Huddinge");
        Address address4 = new Address("Lidingovagen 69", "686-69", "Lidingo");

        addressService.save(address1);
        addressService.save(address2);
        addressService.save(address3);
        addressService.save(address4);

        Project project1 = new Project("Mieszkanie Centrum", address1, customer1);
        Project project2 = new Project("Block Alvsio", address2, customer1);
        Project project3 = new Project("Remont Pokoju", address3, customer2);
        Project project4 = new Project("Lustro Lazienka", address4, customer3);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);
        projectService.save(project4);

        Worker worker1 = new Worker("Sebastian", "Bakowski");
        Worker worker2 = new Worker("Sebastian", "Gaciarz");
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

        Report report1 = new Report(worker1, LocalDate.of(2019, 3, 22), project1, LocalTime.of(7, 0), LocalTime.of(16, 0), Lunch.NO_LUNCH, "rywning grund");
        report1.calculateTotalHours();

        Report report2 = new Report(worker2, LocalDate.of(2019, 3, 22), project1, LocalTime.of(7, 0), LocalTime.of(16, 0), Lunch.HALF_TIME, "rywning grund");
        report2.calculateTotalHours();

        Report report3 = new Report(worker3, LocalDate.of(2019, 3, 25), project2, LocalTime.of(7, 0), LocalTime.of(16, 0), Lunch.FULL_TIME, "kompletowanie");
        report3.calculateTotalHours();

        Report report4 = new Report(worker1, LocalDate.of(2019, 3, 27), project3, LocalTime.of(7, 0), LocalTime.of(16, 0), Lunch.NO_LUNCH, "spotkanie");
        report4.calculateTotalHours();

        Report report5 = new Report(worker2, LocalDate.of(2019, 3, 27), project3, LocalTime.of(7, 0), LocalTime.of(16, 0), Lunch.FULL_TIME, "spotkanie");
        report5.calculateTotalHours();

        Report report6 = new Report(worker3, LocalDate.of(2019, 3, 27), project3, LocalTime.of(7, 0), LocalTime.of(16, 0), Lunch.FULL_TIME, "spotkanie");
        report6.calculateTotalHours();

        Report report7 = new Report(worker1, LocalDate.of(2019, 3, 28), project4, LocalTime.of(7, 0), LocalTime.of(16, 0), Lunch.FULL_TIME, "grund");
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
