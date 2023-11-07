package com.ws.app.business;

import com.ws.app.model.PriceResponse;
import com.ws.app.model.PricesResponse;
import com.ws.app.model.RequestPriceFilter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPriceBusiness {

 Mono<PriceResponse> getPriceByFilter(RequestPriceFilter filter);
 Flux<PricesResponse> getAll();
}
