package com.test.inditex.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Jacksonized
public class BrandRS implements Serializable {

    private static final long serialVersionUID = -7299543196396486673L;

    Long productId;
    Long brandId;
    int fareApplied;
    LocalDateTime startDate;
    LocalDateTime endDate;
    BigDecimal totalPrice;
    String currency;
}
