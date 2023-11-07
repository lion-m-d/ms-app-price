package com.ws.app.business.impl;

import com.ws.app.business.IPriceBusiness;
import com.ws.app.mapper.PriceMapper;
import com.ws.app.model.PriceResponse;
import com.ws.app.model.PricesResponse;
import com.ws.app.model.RequestPriceFilter;
import com.ws.app.service.IBrandService;
import com.ws.app.service.IPriceService;
import com.ws.app.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static com.ws.app.util.Constants.Message.ERROR_PRICE_NOT_FOUND;
import static com.ws.app.util.Util.getDate;
import static com.ws.app.util.Util.getTime;

@Component
@RequiredArgsConstructor
public class PriceBusinessImpl implements IPriceBusiness {

    private final IPriceService priceService;
    private final IBrandService brandService;
    private final IProductService productService;
    private final PriceMapper mapper;

    @Override
    public Mono<PriceResponse> getPriceByFilter(RequestPriceFilter filter) {

          return Mono.zip(brandService.findById(filter.getBrand()),productService.findById(filter.getProduct()))
                .then(Mono.defer(() -> {
                    LocalDateTime targetDateTime = getDate(filter.getDate())
                            .atTime(getTime(filter.getHour()));

                    return priceService.findByBrandAndProduct(filter.getBrand(),filter.getProduct(), targetDateTime)
                            .next()
                            .map(mapper::toResponse)
                            .map(res -> {
                                res.setDate(targetDateTime.toString());
                                return res;
                            })
                            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND , ERROR_PRICE_NOT_FOUND)));
                }));

    }

    @Override
    public Flux<PricesResponse> getAll() {
        return priceService.findAll()
                .map(mapper::allToResponse);
    }

}
