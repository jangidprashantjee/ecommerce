package com.vhkkl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.vhkkl.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
