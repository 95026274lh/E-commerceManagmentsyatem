package com.jsp.E_commerceManagmentsyatem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "myprod")
    @SequenceGenerator(name ="myprod", allocationSize = 10,initialValue = 1)
    private Long productId;
    private String prodname;
    private Double prodprice;
    private String proddescription;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
}
