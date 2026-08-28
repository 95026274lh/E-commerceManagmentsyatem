package com.jsp.E_commerceManagmentsyatem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PaymentRequestDto {
    @NotBlank(message = "payment type is required")
    private String method;
    @Positive(message = "amount should be greater than zero")
    private Double amount;
    @NotBlank(message = "status is required")
    private String paymentstatus;
    @NotNull
    private Long orderId;
}
