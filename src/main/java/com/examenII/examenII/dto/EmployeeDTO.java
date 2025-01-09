package com.examenII.examenII.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EmployeeDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private  String first_name;
    private  String last_name;
    private LocalDate hire_date;
    private String position;
}
