package com.jsp.E_commerceManagmentsyatem.repository;

import com.jsp.E_commerceManagmentsyatem.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {
}
