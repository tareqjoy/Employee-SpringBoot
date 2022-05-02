package com.qerat.employee.employee.api;

import com.qerat.employee.employee.api.exception.HttpException;
import com.qerat.employee.employee.model.EmployeeInfoDto;
import com.qerat.employee.employee.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/employee-info")
@RestController
public class EmployeeInfoController {
    private final EmployeeInfoService employeeInfoService;

    @Autowired
    public EmployeeInfoController(EmployeeInfoService employeeInfoService) {
        this.employeeInfoService = employeeInfoService;
    }

    @PostMapping("add")
    public ResponseEntity<Void> addEmployeeInfo(@Valid @NotNull @RequestBody EmployeeInfoDto info) {
        employeeInfoService.addEmployeeInfo(info);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("query/all")
    public ResponseEntity<List<EmployeeInfoDto>> getAllEmployeeInfo() {
        return new ResponseEntity<>(employeeInfoService.getAllEmployeeInfo(), HttpStatus.OK);
    }

    @GetMapping(path = "query/id/{id}")
    public ResponseEntity<EmployeeInfoDto> getEmployeeInfoById(@PathVariable("id") UUID id) {
        EmployeeInfoDto info = employeeInfoService.getEmployeeInfoById(id);
        if(info == null) {
            throw new HttpException(HttpStatus.NOT_FOUND, "no such user with id");
        } else {
            return new ResponseEntity<>(info, HttpStatus.OK);
        }
    }

    @DeleteMapping("delete/id/{id}")
    public ResponseEntity<Void> deleteEmployeeInfoById(@PathVariable("id") UUID id) {
        employeeInfoService.deleteEmployeeInfoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update/id/{id}")
    public void updateEmployeeInfoById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody EmployeeInfoDto info) {
        employeeInfoService.updateEmployeeInfoById(id, info);
    }
}
