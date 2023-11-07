package com.ws.app.service.impl;

import com.ws.app.model.ProductEntity;
import com.ws.app.repository.IProductRepository;
import com.ws.app.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Optional;

class ProductServiceTest {

    @Mock
    private IProductRepository repository;

    private IProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductService(repository);
    }

    @Test
    void testFindByIdProduct() {

        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(new ProductEntity()));
        Mono<ProductEntity> result = productService.findById(1);

        StepVerifier.create(result)
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

    @Test
    void testFindByIdProductNotFound() {

        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Mono<ProductEntity> result = productService.findById(1);

        StepVerifier.create(result)
                .expectError()
                .verify();
    }

}
