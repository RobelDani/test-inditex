package com.test.inditex.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchPricesRQ implements Serializable {

    private static final long serialVersionUID = -2958801612700635942L;

    @NotNull(message = "dateApplication missing or invalid")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime dateApplication;
    Long productId;
    Long brandId;

    @JsonCreator
    public SearchPricesRQ(@JsonProperty("dateApplication") final LocalDateTime dateApplication, @JsonProperty("productId") final Long productId,
                          @JsonProperty("brandId") final Long brandId) {
        this.dateApplication = dateApplication;
        this.productId = productId;
        this.brandId = brandId;
    }
}
