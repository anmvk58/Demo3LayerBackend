package com.itx.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DemoMavenSelect
{
    public static void main( String[] args ) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));

        //Khai báo các tham số để khởi tạo connection với Database
        String dbUrl = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        // Khởi tạo đối tượng connection tới DB
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        // Khởi tạo đối tượng Statement từ Connection
        Statement statement = connection.createStatement();

        // Chạy câu lệnh và hứng kết quả vào Result Set
        ResultSet resultSet = statement.executeQuery("SELECT * FROM department");

        // In kết quả ra màn hình:
        while(resultSet.next()){
            System.out.print(resultSet.getString(1));
            System.out.print(" | ");
            System.out.println(resultSet.getString("DepartmentName"));
        }
    }
}
