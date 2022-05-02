package com.qerat.employee.employee.model.mapper;

import com.qerat.employee.employee.model.EmployeeInfoDto;
import com.qerat.employee.employee.model.db.EmployeeInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeInfoMapper {
    EmployeeInfoDto toDto(EmployeeInfo info);
    EmployeeInfo toEntity(EmployeeInfoDto info);
}
