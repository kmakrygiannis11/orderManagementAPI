package com.order.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.management.entities.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

}
