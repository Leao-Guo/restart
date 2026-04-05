package com.example.payment.dto;

import com.example.payment.model.PayChannelType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PaymentCreateRequest {
  @NotBlank
  private String orderNo;

  @NotNull
  @DecimalMin(value = "0.01")
  private BigDecimal amount;

  @NotNull
  private PayChannelType payChannel;

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
}
