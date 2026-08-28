package com.jsp.E_commerceManagmentsyatem.controller;

import com.jsp.E_commerceManagmentsyatem.dto.PaymentRequestDto;
import com.jsp.E_commerceManagmentsyatem.dto.PaymentResponseDto;
import com.jsp.E_commerceManagmentsyatem.entity.PaymentEntity;
import com.jsp.E_commerceManagmentsyatem.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> create(@Valid  @PathVariable Long id, @RequestBody PaymentRequestDto paymentRequestDto){
        return paymentService.create(id,paymentRequestDto);
    }@GetMapping
    public ResponseEntity<List<PaymentEntity>> fetchall(){
        return paymentService.fetchall();
    }
    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponseDto> fetchbyid(@Valid @PathVariable Long paymentId){
        return paymentService.fetchbyid(paymentId);
    }
    @DeleteMapping
    public String deleteall(){
        return paymentService.deleteall();
    }
}
