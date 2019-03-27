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

        Customer teresa = new Customer("Teresa", "Kulon", "123456789", false, "teresa@gmail.com");
        customerService.save(teresa);

        Customer wasil = new Customer("Wasil", "Chuj", "987654321", "Wasilbygg", true, "wasilbygg@chuj.com");
        customerService.save(wasil);

        Address lidingoAddress = new Address("LidingoAddress 22", "123-45", "Stockholm");
        Address cityAddress = new Address("cityAddress 89", "453-12", "Stockholm");

        Project lidingo = new Project("Villa 3 piertra", lidingoAddress, wasil);
        Project city = new Project("Remont mieszkania i dupa jasia", cityAddress, wasil);

        addressService.save(lidingoAddress);
        addressService.save(cityAddress);
        projectService.save(lidingo);
        projectService.save(city);

        Worker sebastian = new Worker("Sebastian", "Bakowski");

        Worker mariusz = new Worker("Mariusz", "Gaciarz");

        Report first = new Report(sebastian, LocalDate.now(), lidingo,
                                LocalTime.of(7, 0),
                                LocalTime.of(16, 0),
                                false,
                                "grund installacja kök");

        first.calculateTotalHours();

        Report sec = new Report(mariusz, LocalDate.now(), lidingo,
                LocalTime.of(7, 0),
                LocalTime.of(16, 0),
                true,
                "grund installacja badrum");
        sec.calculateTotalHours();

        sebastian.addProject(lidingo);
        mariusz.addProject(lidingo);
        workerService.save(sebastian);
        workerService.save(mariusz);

        reportService.save(first);
        reportService.save(sec);









    }
}
