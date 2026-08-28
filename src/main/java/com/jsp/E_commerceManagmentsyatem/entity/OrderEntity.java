package com.jsp.E_commerceManagmentsyatem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "myorder")
    @SequenceGenerator(name ="myorder",sequenceName = "order_seq", allocationSize = 1,initialValue = 1)
    private int ordid;
    @Column(nullable = false)
    private String ordname;
    @Column(nullable = false)
    private double ordprice;
    @Column(nullable = false)
    private LocalDate orddate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductEntity> products;
    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    @JsonIgnore
    private PaymentEntity paymentEntity;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "ordid=" + ordid +
                ", ordname='" + ordname + '\'' +
                ", ordprice=" + ordprice +
                ", orddate=" + orddate +
                ", user=" + user +
                '}';
    }
}
