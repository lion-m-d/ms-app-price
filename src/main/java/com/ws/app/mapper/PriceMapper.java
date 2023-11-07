package com.ws.app.mapper;

import com.ws.app.model.PriceEntity;
import com.ws.app.model.PriceResponse;
import com.ws.app.model.PricesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mappings({
            @Mapping(target = "brand", source = "brand.id"),
            @Mapping(target = "product", source = "product.id"),
            @Mapping(target = "priceList", source = "id")
    })
    PriceResponse toResponse(PriceEntity price);
    @Mappings({
            @Mapping(target = "brand", source = "brand.name"),
            @Mapping(target = "product", source = "product.name"),
            @Mapping(target = "priceList", source = "id")
    })
    PricesResponse allToResponse(PriceEntity price);
}
