package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Order;

@CrossOrigin("*")
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

}
