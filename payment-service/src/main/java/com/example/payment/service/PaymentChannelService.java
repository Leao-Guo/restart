package com.example.payment.service;

import com.example.payment.dto.ChannelPayResult;
import com.example.payment.model.PayChannelType;
import com.example.payment.model.Payment;

public interface PaymentChannelService {
  PayChannelType channel();

  ChannelPayResult createOrder(Payment payment);
}

