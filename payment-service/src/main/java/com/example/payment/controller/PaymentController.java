package com.example.payment.controller;

import com.example.payment.dto.PaymentCreateRequest;
import com.example.payment.dto.PaymentResponse;
import com.example.payment.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping
  public ResponseEntity<PaymentResponse> create(@Valid @RequestBody PaymentCreateRequest request) {
    return ResponseEntity.ok(paymentService.createPayment(request));
  }

  @GetMapping("/{id}")
  public ResponseEntity<PaymentResponse> getById(@PathVariable Long id) {
    PaymentResponse response = paymentService.getById(id);
    if (response == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(response);
  }

  @GetMapping("/order/{orderNo}")
  public ResponseEntity<PaymentResponse> getByOrderNo(@PathVariable String orderNo) {
    PaymentResponse response = paymentService.getByOrderNo(orderNo);
    if (response == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(response);
  }
}
