package com.jsp.E_commerceManagmentsyatem.dto;

import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDate;
@Data
public class OrderResponseDto {
      private int ordid;
    private String ordname;

    private double ordprice;

    private LocalDate orddate;
    private UserResponseDto user;
}
