        package com.jsp.E_commerceManagmentsyatem.dto;


    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Positive;
    import lombok.Data;

    @Data
    public class ProductRequestDto {
        @NotBlank(message = "product name is required")
        private String prodname;
        @Positive(message = "price should be greater than zero")
        private Double prodprice;
        @NotBlank(message = "description is required")
        private String proddescription;
        @NotNull(message = "id is required")
        private Long OrderId;


    }
