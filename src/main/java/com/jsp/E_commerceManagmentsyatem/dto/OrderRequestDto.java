package com.jsp.E_commerceManagmentsyatem.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDate;
@Data
public class OrderRequestDto {
    @NotBlank(message = "ordername is required")
    private String ordname;
    @Positive( message = " order price should ne greater than zero")
    private double ordprice;
    @NotNull(message = "order date is required")
    private LocalDate orddate;
//    private User user;
}
