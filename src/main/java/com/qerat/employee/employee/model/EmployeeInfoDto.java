package com.qerat.employee.employee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

public class EmployeeInfoDto implements Serializable {
    @JsonProperty("id")
    private final UUID id;

    @NotBlank
    @JsonProperty("name")
    private final String name;

    public EmployeeInfoDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
