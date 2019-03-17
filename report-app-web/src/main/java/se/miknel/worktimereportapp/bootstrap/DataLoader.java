package se.miknel.worktimereportapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.miknel.worktimereportapp.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Worker seba = Worker.builder()
                .firstName("Sebastian")
                .lastName("Bakowski")
                .speciality(Speciality.ELECTRICIAN)
                .build();

        Worker mariusz = Worker.builder()
                .firstName("Mariusz")
                .lastName("Gaciarz")
                .speciality(Speciality.HELPER)
                .build();

        Set<Worker> workers = new HashSet<>();
        workers.add(seba);
        workers.add(mariusz);

        Address project1Address = Address.builder()
                .streetAddress("Harpsundsvägen 65")
                .zipCode("12458")
                .city("Stockholm")
                .build();

        Customer customer = Customer.builder()
                .firstName("Liliana")
                .lastName("Svensson")
                .address(project1Address)
                .build();

        Project project = Project.builder()
                .description("Projekt dla Wasila")
                .address(project1Address)
                .customer(customer)
                .projectStart(LocalDate.now())
                .projectFinish(null)
                .workers(workers)
                .build();

        ReportWork work1 = ReportWork.builder()
                .worker(seba)
                .date(LocalDate.now())
                .project(project)
                .startWork(LocalDateTime.of(LocalDate.now(), LocalTime.of(7, 00)))
                .stopWork(LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 00)))
                .description("grund kuchnia")
                .build();

        System.out.println(work1.toString());



    }
}
