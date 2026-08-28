package com.jsp.E_commerceManagmentsyatem.service;

import com.jsp.E_commerceManagmentsyatem.dto.PaymentRequestDto;
import com.jsp.E_commerceManagmentsyatem.dto.PaymentResponseDto;
import com.jsp.E_commerceManagmentsyatem.entity.OrderEntity;
import com.jsp.E_commerceManagmentsyatem.entity.PaymentEntity;
import com.jsp.E_commerceManagmentsyatem.repository.OrderRepository;
import com.jsp.E_commerceManagmentsyatem.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private  final PaymentRepository paymentRepository;
    private  final OrderRepository orderRepository;

    public ResponseEntity<PaymentResponseDto> create(Long id, PaymentRequestDto paymentRequestDto){
        OrderEntity order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("id is not found"));
        PaymentEntity paymentEntity=new PaymentEntity();
        paymentEntity.setAmount(paymentRequestDto.getAmount());
        paymentEntity.setMethod(paymentRequestDto.getMethod());
        paymentEntity.setPaymentstatus(paymentRequestDto.getPaymentstatus());
        paymentEntity.setOrder(order);
        PaymentEntity save=paymentRepository.save(paymentEntity);
        PaymentResponseDto paymentResponseDto=new PaymentResponseDto();
        paymentResponseDto.setPaymentId(save.getPaymentId());
        paymentResponseDto.setAmount(save.getAmount());
        paymentResponseDto.setPaymentMethod(save.getMethod());
        paymentResponseDto.setPaymentStatus(save.getPaymentstatus());
        paymentResponseDto.setOrderId((long) save.getOrder().getOrdid());

        return ResponseEntity.ok(paymentResponseDto);
    }
    public ResponseEntity<List<PaymentEntity>> fetchall(){
        return ResponseEntity.ok(paymentRepository.findAll());
    }
    public ResponseEntity<PaymentResponseDto> fetchbyid(Long paymentId){
        PaymentEntity paymentEntity=paymentRepository.findById(paymentId).orElseThrow(()->new RuntimeException("invalid not found"));
        PaymentResponseDto paymentResponseDto=new PaymentResponseDto();
        paymentResponseDto.setPaymentId(paymentEntity.getPaymentId());
        paymentResponseDto.setAmount(paymentEntity.getAmount());
        paymentResponseDto.setPaymentMethod(paymentEntity.getMethod());
        paymentResponseDto.setPaymentStatus(paymentEntity.getPaymentstatus());
        if(paymentEntity.getOrder()!=null)
            paymentResponseDto.setOrderId((long) paymentEntity.getOrder().getOrdid());

    return ResponseEntity.status(HttpStatus.FOUND).body(paymentResponseDto);
    }
    public String deleteall(){
        paymentRepository.deleteAll();
        return "payments are deleted";

    }
}
