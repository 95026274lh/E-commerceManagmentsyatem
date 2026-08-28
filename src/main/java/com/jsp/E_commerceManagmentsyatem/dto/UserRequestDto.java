package com.jsp.E_commerceManagmentsyatem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank(message = "name is required")
    private String name;
    @Email(message = "invalid email")
    @NotBlank(message = "email is required")
    private String email;
    @NotNull(message = "mobile is required")
    @Pattern(regexp = "^[0-9]{10}$",message = " mobile must be 10 digits")
    private String mobile;

}
