package com.itx.frontend;

import com.itx.backend.presentationLayer.DepartmentController;
import com.itx.entity.Department;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Program {
    public static void main(String[] args) throws SQLException, IOException {
        DepartmentController departmentController = new DepartmentController();

        List<Department> list = departmentController.getListDepartment();

        System.out.println("Danh sach Department:");

        for (Department department: list) {
            System.out.println(department.toString());
        }
    }
}
