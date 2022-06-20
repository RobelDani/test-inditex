package com.test.inditex.service;

import com.test.inditex.entity.Prices;
import com.test.inditex.repository.PricesRepository;
import com.test.inditex.request.SearchPricesRQ;
import com.test.inditex.response.BrandRS;
import com.test.inditex.response.SearchPricesRS;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PricesService {

    private final PricesRepository pricesRepository;

    public PricesService(final PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public void save(final List<Prices> prices) {
        pricesRepository.saveAll(prices);
    }

    public SearchPricesRS findPrices(final SearchPricesRQ searchPricesRQ) {
        final List<Prices> prices = pricesRepository.findPrices(searchPricesRQ.getDateApplication(),
                searchPricesRQ.getBrandId(), searchPricesRQ.getProductId());

        final BrandRS brandRS = prices.stream()
                .max(Comparator.comparing(Prices::getPriority))
                .map(this::createBrandRS)
                .orElseThrow(() -> new AssertionError("No se han encontrado precios para los criterios solicitados."));

        return new SearchPricesRS(brandRS);
    }

    private BrandRS createBrandRS(final Prices prices) {
        return BrandRS.builder()
                .productId(prices.getProduct().getId())
                .brandId(prices.getBrand().getId())
                .fareApplied(prices.getPriceList())
                .startDate(prices.getStartDate())
                .endDate(prices.getEndDate())
                .totalPrice(prices.getPrice())
                .currency(prices.getCurr())
                .build();
    }
}
