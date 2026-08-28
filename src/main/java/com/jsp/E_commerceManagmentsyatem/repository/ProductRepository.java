package com.jsp.E_commerceManagmentsyatem.repository;

import com.jsp.E_commerceManagmentsyatem.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long > {
Optional<ProductEntity>findById(Long productId);
Optional<ProductEntity>findByprodname(String prodname);

}
