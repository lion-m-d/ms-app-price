package com.ws.app.mapper;

import com.ws.app.model.BrandEntity;
import com.ws.app.model.PriceEntity;
import com.ws.app.model.PriceResponse;
import com.ws.app.model.PricesResponse;
import com.ws.app.model.ProductEntity;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-07T21:19:44+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public PriceResponse toResponse(PriceEntity price) {
        if ( price == null ) {
            return null;
        }

        PriceResponse priceResponse = new PriceResponse();

        Long id = priceBrandId( price );
        if ( id != null ) {
            priceResponse.setBrand( id.intValue() );
        }
        Long id1 = priceProductId( price );
        if ( id1 != null ) {
            priceResponse.setProduct( id1.intValue() );
        }
        priceResponse.setPriceList( price.getId() );
        priceResponse.setPrice( price.getPrice() );

        return priceResponse;
    }

    @Override
    public PricesResponse allToResponse(PriceEntity price) {
        if ( price == null ) {
            return null;
        }

        PricesResponse pricesResponse = new PricesResponse();

        pricesResponse.setBrand( priceBrandName( price ) );
        pricesResponse.setProduct( priceProductName( price ) );
        pricesResponse.setPriceList( price.getId() );
        if ( price.getStartDate() != null ) {
            pricesResponse.setStartDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( price.getStartDate() ) );
        }
        if ( price.getEndDate() != null ) {
            pricesResponse.setEndDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( price.getEndDate() ) );
        }
        pricesResponse.setPriority( String.valueOf( price.getPriority() ) );
        pricesResponse.setPrice( price.getPrice() );
        pricesResponse.setCurrency( price.getCurrency() );

        return pricesResponse;
    }

    private Long priceBrandId(PriceEntity priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }
        BrandEntity brand = priceEntity.getBrand();
        if ( brand == null ) {
            return null;
        }
        Long id = brand.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long priceProductId(PriceEntity priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }
        ProductEntity product = priceEntity.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String priceBrandName(PriceEntity priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }
        BrandEntity brand = priceEntity.getBrand();
        if ( brand == null ) {
            return null;
        }
        String name = brand.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String priceProductName(PriceEntity priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }
        ProductEntity product = priceEntity.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
