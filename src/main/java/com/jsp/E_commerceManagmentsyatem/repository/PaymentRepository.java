package com.jsp.E_commerceManagmentsyatem.repository;

import com.jsp.E_commerceManagmentsyatem.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository  extends JpaRepository<PaymentEntity,Long> {
}
