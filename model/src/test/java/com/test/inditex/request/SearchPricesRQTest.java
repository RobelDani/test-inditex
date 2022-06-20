package com.test.inditex.request;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = JacksonAutoConfiguration.class)
@JsonTest
class SearchPricesRQTest {
    //language=JSON
    private static final String JSON_OBJECT = "{\n" +
            "  \"dateApplication\": \"2018-10-12T10:00:00\",\n" +
            "  \"productId\": 1,\n" +
            "  \"brandId\": 1\n" +
            "}";

    private static final SearchPricesRQ EXPECTED_OBJECT = new SearchPricesRQ(LocalDateTime.of(2018, 10, 12, 10, 0, 0),
            1L, 1L);

    @Autowired
    private JacksonTester<SearchPricesRQ> jacksonTester;

    @Test
    void shouldSerialize() throws IOException {
        assertThat(this.jacksonTester.write(EXPECTED_OBJECT)).isEqualToJson(JSON_OBJECT);
    }
}