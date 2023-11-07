package com.ws.app.service.impl;

import com.ws.app.model.PriceEntity;
import com.ws.app.repository.IPriceRepository;
import com.ws.app.service.IPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService implements IPriceService {


    private final IPriceRepository repository;
    @Override
    public Flux<PriceEntity> findAll() {
        return  Flux.defer(() -> Flux.fromIterable(repository.findAll()));
    }


    @Override
    public Flux<PriceEntity> findByBrandAndProduct(long brandId , long productId , LocalDateTime targetDateTime) {
       return Flux.defer(() -> Flux.fromIterable(repository.findByBrandIdAndProductIdOrderByPriorityDesc(brandId,productId,targetDateTime)));
    }


}
