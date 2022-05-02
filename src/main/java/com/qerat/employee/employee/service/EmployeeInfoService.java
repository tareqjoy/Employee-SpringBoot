package com.qerat.employee.employee.service;

import com.qerat.employee.employee.dao.EmployeeInfoDao;
import com.qerat.employee.employee.model.EmployeeInfoDto;
import com.qerat.employee.employee.model.mapper.EmployeeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeInfoService {

    private final EmployeeInfoDao employeeInfoDao;
    private final EmployeeInfoMapper mapper;

    @Autowired
    public EmployeeInfoService(
            @Qualifier("postgres") EmployeeInfoDao employeeInfoDao,
            @Qualifier("employeeInfoMapperDefault") EmployeeInfoMapper mapper
    ) {
        this.employeeInfoDao = employeeInfoDao;
        this.mapper = mapper;
    }

    public void addEmployeeInfo(EmployeeInfoDto info) {
        employeeInfoDao.insertEmployeeInfo(mapper.toEntity(info));
    }

    public List<EmployeeInfoDto> getAllEmployeeInfo() {
        return employeeInfoDao
                .getAllEmployeeInfo()
                .stream()
                .map(infoEntity ->
                        new EmployeeInfoDto(infoEntity.getId(), infoEntity.getName())
                )
                .collect(Collectors.toList());
    }

    public EmployeeInfoDto getEmployeeInfoById(UUID id) {
        return mapper.toDto(employeeInfoDao.getEmployeeInfoById(id));
    }

    public void deleteEmployeeInfoById(UUID id) {
        employeeInfoDao.deleteEmployeeInfoById(id);
    }

    public void updateEmployeeInfoById(UUID id, EmployeeInfoDto info) {
        employeeInfoDao.updateEmployeeInfoById(id, mapper.toEntity(info));
    }
}
