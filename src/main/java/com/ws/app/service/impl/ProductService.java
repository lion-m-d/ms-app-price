package com.ws.app.service.impl;

import com.ws.app.model.ProductEntity;
import com.ws.app.repository.IProductRepository;
import com.ws.app.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static com.ws.app.util.Constants.Message.ERROR_PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {


    private final IProductRepository repository;

    @Override
    public Mono<ProductEntity> findById(long productId) {
        return Mono.fromCallable(() -> repository.findById(productId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND , ERROR_PRODUCT_NOT_FOUND)));
    }
}
