package com.jsp.E_commerceManagmentsyatem.dto;

import lombok.Data;

@Data
public class PaymentResponseDto {
    private Long paymentId;
    private Double amount;
    private String paymentMethod;
    private String paymentStatus;
    private Long orderId;
}
