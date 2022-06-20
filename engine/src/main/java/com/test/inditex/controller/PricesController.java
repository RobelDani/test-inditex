package com.test.inditex.controller;

import com.test.inditex.request.SearchPricesRQ;
import com.test.inditex.response.SearchPricesRS;
import com.test.inditex.service.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PricesController {

    private final PricesService pricesService;

    @PostMapping
    public SearchPricesRS getPrices(@RequestBody @Valid final SearchPricesRQ searchPricesRQ) {
        return this.pricesService.findPrices(searchPricesRQ);
    }
}
