package com.example.payment.repo;

import com.example.payment.model.Payment;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
  Optional<Payment> findByOrderNo(String orderNo);
}
