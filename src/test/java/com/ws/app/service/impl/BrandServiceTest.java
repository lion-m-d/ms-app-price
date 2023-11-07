package com.ws.app.service.impl;

import com.ws.app.model.BrandEntity;
import com.ws.app.repository.IBrandRepository;
import com.ws.app.service.IBrandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Optional;

class BrandServiceTest {

    @Mock
    private IBrandRepository repository;

    private IBrandService brandService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        brandService = new BrandService(repository);
    }

    @Test
    void testFindByIdProduct() {
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(new BrandEntity()));
        Mono<BrandEntity> result = brandService.findById(1);

        StepVerifier.create(result)
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

    @Test
    void testFindByIdProductNotFound() {

        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Mono<BrandEntity> result = brandService.findById(1);

        StepVerifier.create(result)
                .expectError()
                .verify();
    }

}
