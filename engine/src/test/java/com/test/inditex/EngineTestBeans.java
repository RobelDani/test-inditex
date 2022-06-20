package com.test.inditex;

import com.test.inditex.entity.Brand;
import com.test.inditex.entity.Prices;
import com.test.inditex.entity.Product;
import com.test.inditex.request.SearchPricesRQ;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EngineTestBeans {

    public static final SearchPricesRQ SEARCH_PRICES_RQ = new SearchPricesRQ(LocalDateTime.of(2022, 9, 17, 10, 0, 0),
            1L, 1L);

    public static final Prices PRICES = Prices.builder()
            .id(1L)
            .brand(Brand.builder().id(1L).build())
            .product(Product.builder().id(1L).build())
            .startDate(LocalDateTime.of(2022, 6, 17, 10, 0, 0))
            .endDate(LocalDateTime.of(2022, 12, 19, 11, 0, 0))
            .priceList(1)
            .priority(1)
            .price(BigDecimal.TEN)
            .curr("EUR")
            .build();
}
