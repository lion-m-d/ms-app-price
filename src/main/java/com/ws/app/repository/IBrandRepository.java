package com.ws.app.repository;

import com.ws.app.model.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<BrandEntity,Long> {

}