package ru.sf.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sf.restapi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}