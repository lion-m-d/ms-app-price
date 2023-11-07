package com.ws.app.service;

import com.ws.app.model.ProductEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {


    Mono<ProductEntity> findById(long productId);

}
