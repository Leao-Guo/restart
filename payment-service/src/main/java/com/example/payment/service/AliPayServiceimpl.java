package com.example.payment.service;

import com.example.payment.dto.ChannelPayResult;
import com.example.payment.model.PayChannelType;
import com.example.payment.model.Payment;
import java.math.RoundingMode;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AliPayServiceimpl implements PaymentChannelService {
  private final String gatewayUrl;

  public AliPayServiceimpl(@Value("${payment.alipay.gateway-url:https://openapi.alipay.com/gateway.do}") String gatewayUrl) {
    this.gatewayUrl = gatewayUrl;
  }

  @Override
  public PayChannelType channel() {
    return PayChannelType.ALIPAY;
  }

  @Override
  public ChannelPayResult createOrder(Payment payment) {
    String tradeNo = "ALI" + UUID.randomUUID().toString().replace("-", "").substring(0, 24).toUpperCase();
    String payUrl = gatewayUrl
        + "?out_trade_no=" + payment.getOrderNo()
        + "&total_amount=" + payment.getAmount().setScale(2, RoundingMode.HALF_UP).toPlainString();
    return ChannelPayResult.success(tradeNo, payUrl);
  }
}
