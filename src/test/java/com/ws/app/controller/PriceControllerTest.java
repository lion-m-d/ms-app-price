package com.ws.app.controller;

import com.ws.app.business.IPriceBusiness;
import com.ws.app.model.PriceResponse;
import com.ws.app.model.PricesResponse;
import com.ws.app.model.RequestPriceFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IPriceBusiness priceBusiness;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testPriceAtDifferentTimesOk() throws Exception {
        List<String[]> scenarios = Arrays.asList(
                new String[]{"2023-09-14", "10:00", "200"},
                new String[]{"2023-09-14", "16:00", "200"},
                new String[]{"2023-09-14", "21:00", "200"},
                new String[]{"2023-09-15", "10:00", "200"},
                new String[]{"2023-09-16", "21:00", "200"}
        );

        for (String[] scenario : scenarios) {
            String date = scenario[0];
            String hour = scenario[1];
            String expectedResult = scenario[2];

            mockMvc.perform(MockMvcRequestBuilders.get("/price")
                            .param("brand", "1")
                            .param("date", date)
                            .param("hour", hour)
                            .param("product", "35455")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(Integer.parseInt(expectedResult)));
        }
    }

    @Test
    void testErrorPriceWhenDateIsNull() throws Exception {
        RequestPriceFilter requestPriceFilter = new RequestPriceFilter();
        requestPriceFilter.setBrand(1);
        requestPriceFilter.setHour("18:31");
        requestPriceFilter.setProduct(35455);


        PriceResponse priceResponse = new PriceResponse();
        when(priceBusiness.getPriceByFilter(requestPriceFilter)).thenReturn(Mono.just(priceResponse));

        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .flashAttr("filter", requestPriceFilter))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    @Test
    void testPriceAllOk() throws Exception {

        when(priceBusiness.getAll()).thenReturn(Flux.just((new PricesResponse())));

        mockMvc.perform(MockMvcRequestBuilders.get("/price/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
