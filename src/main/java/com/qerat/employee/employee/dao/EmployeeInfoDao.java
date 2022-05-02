package com.qerat.employee.employee.dao;

import com.qerat.employee.employee.model.db.EmployeeInfo;

import java.util.List;
import java.util.UUID;

public interface EmployeeInfoDao {
    void insertEmployeeInfo(UUID id, EmployeeInfo info);

    default void insertEmployeeInfo(EmployeeInfo info) {
        insertEmployeeInfo(UUID.randomUUID(), info);
    }

    List<EmployeeInfo> getAllEmployeeInfo();

    EmployeeInfo getEmployeeInfoById(UUID id);

    void deleteEmployeeInfoById(UUID id);

    void updateEmployeeInfoById(UUID id, EmployeeInfo info);
}
