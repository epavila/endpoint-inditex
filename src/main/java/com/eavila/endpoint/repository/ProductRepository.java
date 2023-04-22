package com.eavila.endpoint.repository;

import com.eavila.endpoint.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
