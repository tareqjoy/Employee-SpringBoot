package com.qerat.employee.employee.dao;

import com.qerat.employee.employee.model.db.EmployeeInfo;
import com.qerat.employee.employee.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class PostgresEmployeeInfoDataAccessService implements EmployeeInfoDao {
    private final EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    public PostgresEmployeeInfoDataAccessService(EmployeeInfoRepository employeeInfoRepository) {
        this.employeeInfoRepository = employeeInfoRepository;
    }

    @Override
    public void insertEmployeeInfo(UUID id, EmployeeInfo info) {
        employeeInfoRepository.save(info);
    }

    @Override
    public List<EmployeeInfo> getAllEmployeeInfo() {
        return employeeInfoRepository.getAllEmployeeInfo();
    }

    @Override
    public EmployeeInfo getEmployeeInfoById(UUID id) {
        return employeeInfoRepository.getEmployeeInfoById(id);
    }

    @Override
    public void deleteEmployeeInfoById(UUID id) {
        employeeInfoRepository.deleteEmployeeInfoById(id);
    }

    @Override
    public void updateEmployeeInfoById(UUID id, EmployeeInfo info) {
        employeeInfoRepository.save(info);
    }
}
