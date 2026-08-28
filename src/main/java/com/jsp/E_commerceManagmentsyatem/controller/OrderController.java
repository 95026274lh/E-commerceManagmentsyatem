package com.jsp.E_commerceManagmentsyatem.controller;

import com.jsp.E_commerceManagmentsyatem.dto.OrderRequestDto;
import com.jsp.E_commerceManagmentsyatem.dto.OrderResponseDto;
import com.jsp.E_commerceManagmentsyatem.entity.OrderEntity;
import com.jsp.E_commerceManagmentsyatem.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/{userid}")
    public ResponseEntity<OrderResponseDto> CreateOrder(@Valid  @PathVariable Long userid, @RequestBody OrderRequestDto orderRequestDto){
        System.out.println(" from controller create order");
        return orderService.CreateOrder( userid,orderRequestDto);
    }
    @GetMapping("/all")
    public List<OrderEntity> Fetchallorders(){
        System.out.println(" from controller fetchllorder");
        return orderService.fetchAllOrder();

    }
    @GetMapping("/{ordname}")
    public OrderResponseDto fetchbyname(@Valid @PathVariable String ordname){
        return orderService.fetchbyname(ordname);

    }
    @DeleteMapping("/deleteall")
    public String Delete(){
        return orderService.Delete();
    }
}
