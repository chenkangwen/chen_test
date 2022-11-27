package com.example.demo.commom.jdbc;
 
import java.sql.*;
 
 
public class Jdbc_quickstart {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2、获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day10","root","123456");
        // 3、定义sql
        String sql = "select * from person";
        // 4、获取执行sql的对象
        Statement stmt = conn.createStatement();
        // 5、执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 6、处理结果
        while (rs.next()){
            // 获取数据 两种方式 根据列的索引获取 根据列名获取
            int id = rs.getInt(1);
            String name = rs.getString("name");
            String email = rs.getString("email");
 
            // 打印数据
            System.out.println(id + "----" + name + "----" + email);
        }
        // 7、关闭资源
        rs.close();
        stmt.close();
        conn.close();
 
    }
 
}
 