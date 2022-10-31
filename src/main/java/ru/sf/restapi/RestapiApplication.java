package ru.sf.restapi;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.sf.restapi.entity.Customer;
import ru.sf.restapi.repository.CustomerRepository;

import java.util.List;

@Log
@SpringBootApplication
public class RestapiApplication {

    private final CustomerRepository repository;

    @Autowired
    public RestapiApplication(CustomerRepository repository) {
        this.repository = repository;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<Customer> allCustomers = this.repository.findAll();
        log.info("Number of customers: " + allCustomers.size());

        Customer newCustomer = new Customer();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Doe");
        log.info("Saving new customer...");
        this.repository.save(newCustomer);

        allCustomers = this.repository.findAll();
        log.info("Number of customers: " + allCustomers.size());
    }

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }
}
