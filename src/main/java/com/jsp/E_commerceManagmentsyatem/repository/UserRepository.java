package com.jsp.E_commerceManagmentsyatem.repository;

import com.jsp.E_commerceManagmentsyatem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByemail(String email);
}
