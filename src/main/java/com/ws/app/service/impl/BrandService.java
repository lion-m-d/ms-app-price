package com.ws.app.service.impl;

import com.ws.app.model.BrandEntity;
import com.ws.app.repository.IBrandRepository;
import com.ws.app.service.IBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static com.ws.app.util.Constants.Message.ERROR_BRAND_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BrandService implements IBrandService {

    private final IBrandRepository repository;

    @Override
    public Mono<BrandEntity> findById(long brandId) {
        return Mono.fromCallable(() -> repository.findById(brandId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND , ERROR_BRAND_NOT_FOUND)));
    }
}
