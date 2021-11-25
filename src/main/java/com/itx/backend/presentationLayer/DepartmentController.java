package com.itx.backend.presentationLayer;

import com.itx.backend.businessLayer.DepartmentService;
import com.itx.entity.Department;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController() {
        this.departmentService = new DepartmentService();
    }

    public List<Department> getListDepartment() throws SQLException, IOException {
        return departmentService.getListDepartment();
    }
}
