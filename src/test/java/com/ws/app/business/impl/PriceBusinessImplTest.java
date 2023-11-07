package com.ws.app.business.impl;

import com.ws.app.mapper.PriceMapper;
import com.ws.app.model.*;
import com.ws.app.service.IBrandService;
import com.ws.app.service.IPriceService;
import com.ws.app.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class PriceBusinessImplTest {

    @Mock
    private IPriceService priceService;

    @Mock
    private IProductService productService;

    @Mock
    private IBrandService brandService;

    @Mock
    private PriceMapper mapper;

    @InjectMocks
    private PriceBusinessImpl priceBusiness;


    RequestPriceFilter filter = new RequestPriceFilter();
    PriceEntity priceEntity = new PriceEntity();

    PriceResponse priceResponse = new PriceResponse();
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        String dateStr = "2023-09-28";
        String hourStr = "18:30";

        LocalDateTime dateTime = LocalDateTime.parse(dateStr + "T" + hourStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        filter.setBrand(1);
        filter.setDate(dateStr);
        filter.setHour(hourStr);
        filter.setProduct(35455);


        priceEntity.setStartDate(dateTime.minusDays(1));
        priceEntity.setEndDate(dateTime.plusDays(7));
        priceEntity.setPriority(0) ;
        priceEntity.setPrice(BigDecimal.ZERO);
        priceEntity.setCurrency("USD");
        priceEntity.setProduct(new ProductEntity(1L,"Jeans"));
        priceEntity.setBrand(new BrandEntity(1L,"ZARA"));

        priceResponse.setPriceList(priceEntity.getId());
        priceResponse.setDate(dateTime.toString());
        priceResponse.setPrice(priceEntity.getPrice());
        priceResponse.setProduct(priceEntity.getProduct().getId().intValue());
        priceResponse.setBrand(priceEntity.getBrand().getId().intValue());
    }
    @Test
    void testGetPriceByFilterSuccess() {
        when(brandService.findById(Mockito.anyLong())).thenReturn(Mono.just(new BrandEntity()));
        when(productService.findById(Mockito.anyLong())).thenReturn(Mono.just(new ProductEntity()));
        when(priceService.findByBrandAndProduct(Mockito.anyLong(), Mockito.anyLong(), Mockito.any(LocalDateTime.class)))
                .thenReturn(Flux.just(priceEntity));
        when(mapper.toResponse(Mockito.any(PriceEntity.class))).thenReturn(priceResponse);
        StepVerifier.create(priceBusiness.getPriceByFilter(filter))
                .expectNext(priceResponse)
                .expectComplete()
                .verify();
    }

       @Test
       void testGetPriceByFilterSuccessAnotherDate() {
           String dateStr = "28-09-2023";
           filter.setDate(dateStr);
           when(brandService.findById(Mockito.anyLong())).thenReturn(Mono.just(new BrandEntity()));
           when(productService.findById(Mockito.anyLong())).thenReturn(Mono.just(new ProductEntity()));
           when(priceService.findByBrandAndProduct(Mockito.anyLong(), Mockito.anyLong(),Mockito.any(LocalDateTime.class))).thenReturn(Flux.just(priceEntity));
           when(mapper.toResponse(Mockito.any())).thenReturn(priceResponse);
           StepVerifier.create(priceBusiness.getPriceByFilter(filter))
                   .expectNext(priceResponse)
                   .expectComplete()
                   .verify();
       }

       @Test
       void testGetPriceByFilterOutOfRangeDate() {
           priceEntity.setStartDate(LocalDateTime.now().plusDays(20));
           when(brandService.findById(Mockito.anyLong())).thenReturn(Mono.just(new BrandEntity()));
           when(productService.findById(Mockito.anyLong())).thenReturn(Mono.just(new ProductEntity()));
           when(priceService.findByBrandAndProduct(Mockito.anyLong(), Mockito.anyLong() ,Mockito.any())).thenReturn(Flux.empty());
           when(mapper.toResponse(Mockito.any())).thenReturn(priceResponse);

           StepVerifier.create(priceBusiness.getPriceByFilter(filter))
                   .expectError()
                   .verify();
       }



       @Test
       void testGetPriceByFilterDateErrorFormat() {
           filter.setDate("2023-0-1");
           when(brandService.findById(Mockito.anyLong())).thenReturn(Mono.just(new BrandEntity()));
           when(productService.findById(Mockito.anyLong())).thenReturn(Mono.just(new ProductEntity()));
           StepVerifier.create(priceBusiness.getPriceByFilter(filter))
                   .expectError()
                   .verify();
       }

       @Test
       void testGetPriceByFilterHourErrorFormat() {
           filter.setHour("11:0");
           when(brandService.findById(Mockito.anyLong())).thenReturn(Mono.just(new BrandEntity()));
           when(productService.findById(Mockito.anyLong())).thenReturn(Mono.just(new ProductEntity()));
           StepVerifier.create(priceBusiness.getPriceByFilter(filter))
                   .expectError()
                   .verify();
       }


       @Test
       void testGetPriceByFilterNoResultFound() {
           when(brandService.findById(Mockito.anyLong())).thenReturn(Mono.just(new BrandEntity()));
           when(productService.findById(Mockito.anyLong())).thenReturn(Mono.just(new ProductEntity()));
           when(priceService.findByBrandAndProduct(Mockito.anyLong(), Mockito.anyLong(),Mockito.any())).thenReturn(Flux.empty());

           StepVerifier.create(priceBusiness.getPriceByFilter(filter))
                   .expectError()
                   .verify();
       }
    @Test
    void testGetAllPrices() {
        PriceEntity priceEntity = new PriceEntity();
        PricesResponse expectedResponse = new PricesResponse();

        when(priceService.findAll()).thenReturn(Flux.just(priceEntity));
        when(mapper.allToResponse(priceEntity)).thenReturn(expectedResponse);

        StepVerifier.create(priceBusiness.getAll())
                .expectNext(expectedResponse)
                .expectComplete()
                .verify();
    }
}
