package com.test.inditex.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.inditex.request.SearchPricesRQ;
import com.test.inditex.response.BrandRS;
import com.test.inditex.response.SearchPricesRS;
import com.test.inditex.service.PricesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
class PricesControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PricesService pricesService;
    @InjectMocks
    private PricesController pricesController;

    private JacksonTester<SearchPricesRQ> jacksonTester;

    @Test
    void search_prices() {
        final SearchPricesRQ searchPricesRQ = new SearchPricesRQ(LocalDateTime.of(2020, 6, 14, 10, 0, 0),
                35455L, 1L);
        given(pricesService.findPrices(searchPricesRQ)).willReturn(new SearchPricesRS(BrandRS.builder().build()));

        final SearchPricesRS prices = pricesController.getPrices(searchPricesRQ);
        assertThat(prices).isNotNull();
        assertThat(prices.getBrandRS()).isNotNull();
    }

    private void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(pricesController)
                .build();
    }

    @Test
    public void consultar_dia_14_10_am() throws Exception {
        setUp();
        final SearchPricesRQ searchPricesRQ = new SearchPricesRQ(LocalDateTime.of(2020, 6, 14, 10, 0, 0),
                35455L, 1L);
        final MockHttpServletResponse response = mockMvc.perform(
                post("/api/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonTester.write(searchPricesRQ).getJson()
                        )).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void consultar_dia_14_4_pm() throws Exception {
        setUp();
        final SearchPricesRQ searchPricesRQ = new SearchPricesRQ(LocalDateTime.of(2020, 6, 14, 16, 0, 0),
                1L, 35455L);
        final MockHttpServletResponse response = mockMvc.perform(
                post("/api/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonTester.write(searchPricesRQ).getJson()
                        )).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void consultar_dia_14_9_pm() throws Exception {
        setUp();
        final SearchPricesRQ searchPricesRQ = new SearchPricesRQ(LocalDateTime.of(2020, 6, 14, 21, 0, 0),
                1L, 35455L);
        final MockHttpServletResponse response = mockMvc.perform(
                post("/api/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonTester.write(searchPricesRQ).getJson()
                        )).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void consultar_dia_15_10_am() throws Exception {
        setUp();
        final SearchPricesRQ searchPricesRQ = new SearchPricesRQ(LocalDateTime.of(2020, 6, 15, 10, 0, 0),
                1L, 35455L);
        final MockHttpServletResponse response = mockMvc.perform(
                post("/api/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonTester.write(searchPricesRQ).getJson()
                        )).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void consultar_dia_15_9_pm() throws Exception {
        setUp();
        final SearchPricesRQ searchPricesRQ = new SearchPricesRQ(LocalDateTime.of(2020, 6, 15, 21, 0, 0),
                1L, 35455L);
        final MockHttpServletResponse response = mockMvc.perform(
                post("/api/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonTester.write(searchPricesRQ).getJson()
                        )).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}