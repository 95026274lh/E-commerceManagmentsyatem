package com.jsp.E_commerceManagmentsyatem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mycart")
    @SequenceGenerator(name ="mycart", allocationSize = 100,initialValue = 1)
private Long cartid;


@OneToMany(cascade = CascadeType.ALL)
@JoinTable(
        name = "cart_products",
        joinColumns = @JoinColumn(name = "cart_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id")
)
private List<ProductEntity>products;
}
