package com.itx.backend.businessLayer;

import com.itx.backend.dataLayer.DepartmentRespository;
import com.itx.entity.Department;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    DepartmentRespository departmentRespository;

    public DepartmentService() {
        this.departmentRespository = new DepartmentRespository();
    }

    public List<Department> getListDepartment() throws SQLException, IOException {
        return  departmentRespository.getListDepartment();
    }
}
