package com.test.inditex.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchPricesRS implements Serializable {

    private static final long serialVersionUID = -1436340618996967834L;

    private final BrandRS brandRS;

    @JsonCreator
    public SearchPricesRS(@JsonProperty("brandRS") final BrandRS brandRS) {
        this.brandRS = brandRS;
    }
}
