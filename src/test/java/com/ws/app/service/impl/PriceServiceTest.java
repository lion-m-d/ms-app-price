package com.ws.app.service.impl;

import com.ws.app.model.PriceEntity;
import com.ws.app.repository.IPriceRepository;
import com.ws.app.service.IPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class PriceServiceTest {

    @Mock
    private IPriceRepository repository;

    private IPriceService priceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        priceService = new PriceService(repository);
    }

    @Test
    void testFindAll() {
        List<PriceEntity> priceEntities = new ArrayList<>();
        priceEntities.add(new PriceEntity());

        Mockito.when(repository.findAll()).thenReturn(priceEntities);

        Flux<PriceEntity> result = priceService.findAll();

        StepVerifier.create(result)
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

    @Test
    void testFindByBrandAndProduct() {
        long brandId = 1L;
        long productId = 35455L;
        LocalDateTime targetDateTime= LocalDateTime.now();
        List<PriceEntity> priceEntities = new ArrayList<>();
        priceEntities.add(new PriceEntity());

        Mockito.when(repository.findByBrandIdAndProductIdOrderByPriorityDesc(brandId, productId , targetDateTime))
                .thenReturn(priceEntities);

        Flux<PriceEntity> result = priceService.findByBrandAndProduct(brandId, productId , targetDateTime);

        StepVerifier.create(result)
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }
}
