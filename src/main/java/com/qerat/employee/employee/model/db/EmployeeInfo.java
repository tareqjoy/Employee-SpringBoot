package com.qerat.employee.employee.model.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "employeeinfo")
public class EmployeeInfo {
    @Id
    @Column(name = "id", nullable = false)
    final UUID id;

    @NotNull
    @Column(name = "name")
    final String name;

    public EmployeeInfo(UUID id, String name) {
        if(id==null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.name = name;
    }

    public EmployeeInfo() {
        id=null;
        name=null;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
