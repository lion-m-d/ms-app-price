package com.ws.app.service;

import com.ws.app.model.PriceEntity;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface IPriceService {

    Flux<PriceEntity> findAll();

    Flux<PriceEntity> findByBrandAndProduct(long brandId ,  long productId , LocalDateTime targetDateTime);

}
