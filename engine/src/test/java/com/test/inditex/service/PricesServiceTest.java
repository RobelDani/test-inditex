package com.test.inditex.service;

import com.test.inditex.entity.Brand;
import com.test.inditex.entity.Prices;
import com.test.inditex.entity.Product;
import com.test.inditex.repository.PricesRepository;
import com.test.inditex.request.SearchPricesRQ;
import com.test.inditex.response.SearchPricesRS;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PricesServiceTest {

    private static final SearchPricesRQ SEARCH_PRICES_RQ = new SearchPricesRQ(LocalDateTime.of(2020, 6, 14, 10, 0, 0),
            35455L, 1L);
    public static final Prices PRICES_1 = Prices.builder()
            .priority(0)
            .priceList(2).build();
    public static final Prices PRICES_2 = Prices.builder()
            .priority(1)
            .brand(Brand.builder().id(1L).build())
            .product(Product.builder().id(1L).build())
            .priceList(1).build();

    @Mock
    private PricesRepository pricesRepository;
    @InjectMocks
    private PricesService pricesService;

    @Test
    void find_price_OK() {
        given(pricesRepository.findPrices(SEARCH_PRICES_RQ.getDateApplication(), SEARCH_PRICES_RQ.getBrandId(), SEARCH_PRICES_RQ.getProductId()))
                .willReturn(List.of(PRICES_1, PRICES_2));
        final SearchPricesRS prices = pricesService.findPrices(SEARCH_PRICES_RQ);
        assertThat(prices).isNotNull();
        assertThat(prices.getBrandRS().getFareApplied()).isEqualTo(1);
    }

    @Test
    void find_price_KO() {
        given(pricesRepository.findPrices(SEARCH_PRICES_RQ.getDateApplication(), SEARCH_PRICES_RQ.getBrandId(), SEARCH_PRICES_RQ.getProductId()))
                .willReturn(Collections.emptyList());
        assertThrows(AssertionError.class, () ->
                pricesService.findPrices(SEARCH_PRICES_RQ));
    }
}