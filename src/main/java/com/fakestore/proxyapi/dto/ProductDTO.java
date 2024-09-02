package com.fakestore.proxyapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductDTO {


    //@NotNull(message = "id must be generated")
    private String idProduct;

    //@NotNull
    private String name;

    /*@DecimalMin(value = "0.01", inclusive = true, message = "Value must be greater than 0.01")
    @DecimalMax(value = "10000", inclusive = true, message = "value must be less 10000")*/
    private double cost;

    /*@NotNull
    @Size(min = 0, max = 100, message = "message must be less 100 length")*/
    private String description;

    /*@NotNull
    @Size(min = 0, max = 100, message = "message must be less 100 length")*/
    private String image;

    //@Size(min = 1, max = 25, message = "message must be min 1 and max 25 length")
    private String category;

}
