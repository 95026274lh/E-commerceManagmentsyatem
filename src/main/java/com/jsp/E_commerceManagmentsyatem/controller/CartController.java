package com.jsp.E_commerceManagmentsyatem.controller;

import com.jsp.E_commerceManagmentsyatem.dto.CartRequestDto;
import com.jsp.E_commerceManagmentsyatem.dto.CartResponseDto;
import com.jsp.E_commerceManagmentsyatem.entity.CartEntity;
import com.jsp.E_commerceManagmentsyatem.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private  final CartService cartService;
    @PostMapping("/{productid}")
    public ResponseEntity<CartResponseDto> Addproduct(@Valid  @PathVariable Long productid,@RequestBody CartRequestDto cartRequestDto){
        return cartService.Addproduct(productid,cartRequestDto);
    }
    @GetMapping
    private ResponseEntity <List<CartEntity>>fetchall(){
        return cartService.fetchall();

    }
    @DeleteMapping
    public String Deleteall(){
        return cartService.Deleteall();

    }
}
