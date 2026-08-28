package com.jsp.E_commerceManagmentsyatem.dto;

import lombok.Data;

@Data
public class CartResponseDto {
    private Long cartid;
    private Long productId;
    private String prodname;
    private Double prodprice;
    private String proddescription;
}
