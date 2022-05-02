package com.qerat.employee.employee.dao;

import com.qerat.employee.employee.model.db.EmployeeInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeEmployeeInfoDataAccessService implements EmployeeInfoDao {
    private static List<EmployeeInfo> DB = new ArrayList<>();
    @Override
    public void insertEmployeeInfo(UUID id, EmployeeInfo info) {
        DB.add(new EmployeeInfo(id, info.getName()));
    }

    @Override
    public List<EmployeeInfo> getAllEmployeeInfo() {
        return DB;
    }

    @Override
    public EmployeeInfo getEmployeeInfoById(UUID id) {
        return DB.stream().filter(info -> info.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void deleteEmployeeInfoById(UUID id) {
        EmployeeInfo employeeInfo = getEmployeeInfoById(id);
        if(employeeInfo== null) {
            return;
        }
        DB.remove(employeeInfo);
    }

    @Override
    public void updateEmployeeInfoById(UUID id, EmployeeInfo info) {
        EmployeeInfo oldInfo = getEmployeeInfoById(id);
        if(oldInfo!=null) {
            int idx = DB.indexOf(oldInfo);
            if(idx>=0) {
                DB.set(idx, info);
            }
        }
    }
}
