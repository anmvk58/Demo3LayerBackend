package com.itx.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DemoMavenCallProcedure {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));

        //Khai báo các tham số để khởi tạo connection với Database
        String dbUrl = properties.getProperty("url13579");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        // Khởi tạo đối tượng connection tới DB
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        System.out.println("Kết nối tới DB thành công !");

        // Tạo đối tượng CallableStatement
        String sql = "{CALL update_department(?, ?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);

        // Gán giá trị vào trong statement
        callableStatement.setString(1, "Cristiano Ronaldo");
        callableStatement.setInt(2, 2);

        try{
            int affectedRows = callableStatement.executeUpdate();
            System.out.println("Update Oke " + affectedRows  + " bản ghi !");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
