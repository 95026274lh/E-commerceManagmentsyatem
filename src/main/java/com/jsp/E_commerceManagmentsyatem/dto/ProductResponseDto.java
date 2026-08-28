package com.jsp.E_commerceManagmentsyatem.dto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private Long productId;
    private String prodname;
    private Double prodprice;
    private String proddescription;

    private Long orderId;
}
