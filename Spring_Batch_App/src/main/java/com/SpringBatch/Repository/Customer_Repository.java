package com.SpringBatch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBatch.entity.Customer;

public interface Customer_Repository extends JpaRepository<Customer, Integer> {

}
