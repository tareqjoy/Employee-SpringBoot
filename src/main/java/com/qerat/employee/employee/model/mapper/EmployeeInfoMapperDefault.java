package com.qerat.employee.employee.model.mapper;

import com.qerat.employee.employee.model.EmployeeInfoDto;
import com.qerat.employee.employee.model.db.EmployeeInfo;
import org.springframework.stereotype.Component;

@Component("employeeInfoMapperDefault")
public class EmployeeInfoMapperDefault implements EmployeeInfoMapper {
    @Override
    public EmployeeInfoDto toDto(EmployeeInfo info) {
        if(info == null) {
            return null;
        }
        return new EmployeeInfoDto(info.getId(), info.getName());
    }

    @Override
    public EmployeeInfo toEntity(EmployeeInfoDto info) {
        if(info == null) {
            return null;
        }
        return new EmployeeInfo(info.getId(), info.getName());
    }
}
