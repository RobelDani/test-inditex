package com.test.inditex.response;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = JacksonAutoConfiguration.class)
@JsonTest
class BrandRSTest {
    //language=JSON
    private static final String JSON_OBJECT = "{\n" +
            "       \"productId\": 1,\n" +
            "       \"brandId\": 1,\n" +
            "       \"fareApplied\": 10,\n" +
            "       \"startDate\": \"2022-06-17T10:00:00\",\n" +
            "       \"endDate\": \"2022-12-19T10:00:00\",\n" +
            "       \"currency\": \"EUR\",\n" +
            "       \"totalPrice\": 100\n" +
            "}";

    private static final BrandRS EXPECTED_OBJECT = BrandRS.builder()
            .productId(1L)
            .brandId(1L)
            .fareApplied(10)
            .startDate(LocalDateTime.of(2022, 6, 17, 10, 0, 0))
            .endDate(LocalDateTime.of(2022, 12, 19, 10, 0, 0))
            .currency("EUR")
            .totalPrice(new BigDecimal(100)).build();

    @Autowired
    private JacksonTester<BrandRS> jacksonTester;

    @Test
    void shouldSerialize() throws IOException {
        assertThat(this.jacksonTester.write(EXPECTED_OBJECT)).isEqualToJson(JSON_OBJECT);
    }

    @Test
    void shouldDeserialize() throws IOException {
        assertThat(this.jacksonTester.parse(JSON_OBJECT).getObject()).isEqualTo(EXPECTED_OBJECT);
    }
}