package com.example.payment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Custom {
    @NotNull(message = "id不能为空")
    private Integer id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotBlank(message = "收货地址不能为空")
    private String shippingAddress;

    @NotBlank(message = "电话号码不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "电话号码格式不正确")
    private String phoneNumber;

    @NotBlank(message = "性别不能为空")
    @Pattern(regexp = "^(男|女|其他)$", message = "性别只能是: 男、女、其他")
    private String gender;
}
