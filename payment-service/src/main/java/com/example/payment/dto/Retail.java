package com.example.payment.dto;

import lombok.Data;

@Data
public class Retail {

    //用递归实现斐波那契数列求和
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
