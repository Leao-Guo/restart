package com.example.payment.dto;

import lombok.Data;

import java.sql.*;

@Data
public class Retail {

    //用递归实现斐波那契数列求和
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //用jdbc的api编写一段查询mysql数据库代码，查询一个叫users的表，返回所有用户的名字
    public void queryUsers() {
        // 这里是伪代码，实际使用时需要替换为正确的数据库连接信息
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM users")) {

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
