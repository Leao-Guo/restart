package com.example.payment.service;

import com.example.payment.dto.ChannelPayResult;
import com.example.payment.model.PayChannelType;
import com.example.payment.model.Payment;
import java.math.RoundingMode;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeChatPayServiceImpl implements PaymentChannelService {
  private final String unifiedOrderUrl;

  public WeChatPayServiceImpl(
      @Value("${payment.wechat.unified-order-url:https://api.mch.weixin.qq.com/v3/pay/transactions/native}") String unifiedOrderUrl) {
    this.unifiedOrderUrl = unifiedOrderUrl;
  }

  @Override
  public PayChannelType channel() {
    return PayChannelType.WECHAT;
  }

  @Override
  public ChannelPayResult createOrder(Payment payment) {
    String tradeNo = "WX" + UUID.randomUUID().toString().replace("-", "").substring(0, 24).toUpperCase();
    String payUrl = unifiedOrderUrl
        + "?out_trade_no=" + payment.getOrderNo()
        + "&amount=" + payment.getAmount().setScale(2, RoundingMode.HALF_UP).toPlainString();
    return ChannelPayResult.success(tradeNo, payUrl);
  }
}

