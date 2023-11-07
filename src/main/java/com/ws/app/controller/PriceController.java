package com.ws.app.controller;

import com.ws.app.business.IPriceBusiness;
import com.ws.app.model.PriceResponse;
import com.ws.app.model.PricesResponse;
import com.ws.app.model.RequestPriceFilter;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@Api(value = "Price")
@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class PriceController{

    private  final IPriceBusiness priceBusiness;

    @ApiOperation(value = "Obtener los precios y productos", nickname = "priceAllGet", notes = "Obtener los precios y productos", response = PricesResponse.class, tags={ "Price", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = PriceResponse.class),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 409, message = "Conflict")})
    @GetMapping(
            value = "/price/all",
            produces = { "application/json" }
    )
    public Flux<PricesResponse> getAllPrices(){
        return priceBusiness.getAll();
    }

    @ApiOperation(value = "Obtener precio con los filtros indicados", nickname = "priceGet", notes = "Obtener precios", response = PriceResponse.class, tags={ "Price", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = PriceResponse.class),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 409, message = "Conflict") })
    @GetMapping(
            value = "/price",
            produces = { "application/json" }
    )
    public Mono<PriceResponse> getPriceByFilter(@NotNull @ApiParam(value = "Request Price parameters", required = true) @Valid RequestPriceFilter filter){
        return priceBusiness.getPriceByFilter(filter);
    }

}
