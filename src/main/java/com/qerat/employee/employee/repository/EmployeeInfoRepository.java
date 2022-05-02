package com.qerat.employee.employee.repository;

import com.qerat.employee.employee.model.db.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, UUID> {
    @Query(value = "SELECT info FROM EmployeeInfo info")
    List<EmployeeInfo> getAllEmployeeInfo();

    @Query(value = "SELECT info FROM EmployeeInfo info WHERE info.id = :id")
    EmployeeInfo getEmployeeInfoById(UUID id);

    @Modifying
    @Query(value = "DELETE FROM EmployeeInfo info WHERE info.id = :id")
    EmployeeInfo deleteEmployeeInfoById(UUID id);

}
