package com.itx.backend.dataLayer;

import com.itx.entity.Department;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DepartmentRespository {

    public List<Department> getListDepartment() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));

        //Khai báo các tham số để khởi tạo connection với Database
//        String dbUrl = "jdbc:mysql://localhost:3306/testing_system_assignment";
//        String username = "root";
//        String password = "root";

        String dbUrl = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        // Khởi tạo đối tượng connection tới DB
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        // Khởi tạo đối tượng Statement từ Connection
        Statement statement = connection.createStatement();

        // Chạy câu lệnh và hứng kết quả vào Result Set
        ResultSet resultSet = statement.executeQuery("SELECT * FROM department");

        //Tạo ra danh sách rỗng:
        List<Department> listDepartment = new ArrayList<>();

        while (resultSet.next()){
            Department departmentTemp = new Department(resultSet.getInt("departmentId"), resultSet.getString("departmentName"));
            listDepartment.add(departmentTemp);
        }

        return listDepartment;
    }
}
