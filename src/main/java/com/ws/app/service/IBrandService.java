package com.ws.app.service;

import com.ws.app.model.BrandEntity;
import reactor.core.publisher.Mono;

public interface IBrandService {

    Mono<BrandEntity> findById(long brandId);

}
