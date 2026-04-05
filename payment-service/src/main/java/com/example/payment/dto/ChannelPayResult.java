package com.example.payment.dto;

public class ChannelPayResult {
  private final boolean success;
  private final String channelTradeNo;
  private final String payUrl;
  private final String errorMessage;

  private ChannelPayResult(boolean success, String channelTradeNo, String payUrl, String errorMessage) {
    this.success = success;
    this.channelTradeNo = channelTradeNo;
    this.payUrl = payUrl;
    this.errorMessage = errorMessage;
  }

  public static ChannelPayResult success(String channelTradeNo, String payUrl) {
    return new ChannelPayResult(true, channelTradeNo, payUrl, null);
  }

  public static ChannelPayResult failed(String errorMessage) {
    return new ChannelPayResult(false, null, null, errorMessage);
  }

  public boolean isSuccess() {
    return success;
  }

  public String getChannelTradeNo() {
    return channelTradeNo;
  }

  public String getPayUrl() {
    return payUrl;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}

