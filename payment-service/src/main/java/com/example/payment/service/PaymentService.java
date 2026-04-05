package com.example.payment.service;

import com.example.payment.dto.PaymentCreateRequest;
import com.example.payment.dto.PaymentResponse;
import com.example.payment.model.Payment;
import com.example.payment.model.PaymentStatus;
import com.example.payment.repo.PaymentRepository;
import java.time.Duration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {
    private static final String ORDER_KEY_PREFIX = "payment:order:";
    private static final Duration ORDER_CACHE_TTL = Duration.ofMinutes(10);

    private final PaymentRepository paymentRepository;
    private final StringRedisTemplate stringRedisTemplate;

    public PaymentService(PaymentRepository paymentRepository, StringRedisTemplate stringRedisTemplate) {
        this.paymentRepository = paymentRepository;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Transactional
    public PaymentResponse createPayment(PaymentCreateRequest request) {
        String orderKey = ORDER_KEY_PREFIX + request.getOrderNo();
        String existingId = stringRedisTemplate.opsForValue().get(orderKey);
        if (existingId != null) {
            Payment existing = paymentRepository.findById(Long.valueOf(existingId))
                .orElseGet(() -> paymentRepository.findByOrderNo(request.getOrderNo()).orElse(null));
            if (existing != null) {
                return toResponse(existing);
            }
        }

        Payment payment = new Payment();
        payment.setOrderNo(request.getOrderNo());
        payment.setAmount(request.getAmount());
        payment.setStatus(PaymentStatus.PAID);
        Payment saved = paymentRepository.save(payment);

        stringRedisTemplate.opsForValue().set(orderKey, String.valueOf(saved.getId()), ORDER_CACHE_TTL);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public PaymentResponse getById(Long id) {
        return paymentRepository.findById(id).map(this::toResponse).orElse(null);
    }

    @Transactional(readOnly = true)
    public PaymentResponse getByOrderNo(String orderNo) {
        return paymentRepository.findByOrderNo(orderNo).map(this::toResponse).orElse(null);
    }

    private PaymentResponse toResponse(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setId(payment.getId());
        response.setOrderNo(payment.getOrderNo());
        response.setAmount(payment.getAmount());
        response.setStatus(payment.getStatus());
        response.setCreatedAt(payment.getCreatedAt());
        return response;
    }
}
