package com.ws.app.repository;

import com.ws.app.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity,Long> {

}