package com.jsp.E_commerceManagmentsyatem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mypayment")
    @SequenceGenerator(name = "mypayment",initialValue = 1,allocationSize = 1)
    private Long paymentId;
    private String method;
    private Double amount;
    private String paymentstatus;
    @OneToOne
    @JoinColumn(name = "order_id",unique = true)
    private OrderEntity order;

}
