package com.example.payment.dto;

import com.example.payment.model.PayChannelType;
import com.example.payment.model.PaymentStatus;
import java.math.BigDecimal;
import java.time.Instant;

public class PaymentResponse {
  private Long id;
  private String orderNo;
  private BigDecimal amount;
  private PayChannelType payChannel;
  private PaymentStatus status;
  private String channelTradeNo;
  private String payUrl;
  private Instant createdAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public PayChannelType getPayChannel() {
    return payChannel;
  }

  public void setPayChannel(PayChannelType payChannel) {
    this.payChannel = payChannel;
  }

  public PaymentStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentStatus status) {
    this.status = status;
  }

  public String getChannelTradeNo() {
    return channelTradeNo;
  }

  public void setChannelTradeNo(String channelTradeNo) {
    this.channelTradeNo = channelTradeNo;
  }

  public String getPayUrl() {
    return payUrl;
  }

  public void setPayUrl(String payUrl) {
    this.payUrl = payUrl;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
